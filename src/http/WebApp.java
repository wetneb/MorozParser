package http;

import graphexpr.ExprResolver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.List;

import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.core.Container;
import org.simpleframework.http.core.ContainerServer;
import org.simpleframework.transport.Server;
import org.simpleframework.transport.connect.Connection;
import org.simpleframework.transport.connect.SocketConnection;

import app.SimpleTokenizer;

import com.hp.hpl.jena.rdf.model.Statement;

import pregroup.Parser;
import pregroup.SimpleType;

import rdf.GraphCompiler;
import rdf.GraphString;
import rdf.TypeException;
import tagging.StanfordTagger;
import xmllexicon.InputException;
import xmllexicon.SemanticLexicon;

class UserInputError extends Exception
{
	private static final long serialVersionUID = 1L;
	public String what;
	public UserInputError(String w) { what = w; }
}

public class WebApp implements Container 
{
	private String homePage;
	private String resultPage;
	private String errorPage;
	
	private SemanticLexicon sem;
	private StanfordTagger tagger;
	
	public void handle(Request request, Response response)
	{
		try
		{
			PrintStream body = response.getPrintStream();
			long time = System.currentTimeMillis();
			String pageName = request.getPath().getPath();
			
			response.setValue("Content-Type", "text/html");
			response.setValue("Server", "PregroupSPARQL/1.0 (Simple)");
			response.setDate("Date", time);
			response.setDate("Last-Modified", time);
			
			System.out.println("Requested \""+pageName+"\"");
			if(pageName.equals("/index.html") || pageName.equals("/"))
				body.println(homePage);
			else if(pageName.equals("/process.html"))
				body.println(processSentence(request.getQuery().get("sentence")));
			else
				body.println("404 Page Not Found\n");
			body.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	private String escapeHtml(String input)
	{
		String output = new String(input);
		output = output.replace("&", "&amp;");
		output = output.replace(">", "&gt;");
		return output.replace("<", "&lt;");
	}
	
	private String processSentence(String input)
	{
		String resPage = new String(resultPage);
		String errPage = new String(errorPage);
		
		try
		{
			if(input == null)
			{
				errPage.replace("$SENTENCE", "");
				throw new UserInputError("No input sentence.");
			}
			
			resPage = resPage.replace("$SENTENCE", input);
			errPage = errPage.replace("$SENTENCE", input);
			
			try
			{
				List<String> sentence = new SimpleTokenizer(input).toList();
				SimpleType target =
						new SimpleType("s", 0);
				
				GraphString phrase =
						new GraphString(sem, tagger.tagSentence(sentence), sentence, target);
				
				Parser p = new Parser(phrase, sem.getComparator());
				System.out.println(phrase.toString());
				if(p.run())
				{		
					System.out.println("Valid phrase");
					ExprResolver resolver = new ExprResolver(phrase, p.getReduction());
					GraphCompiler compiler = new GraphCompiler(resolver);
	
					try {
						System.out.println("Valid phrase");
						
						Statement res = compiler.compileStmt(phrase.getPattern(resolver.getEntryPoint()));
						compiler.assume(res);
						System.out.println("Valid phrase");
						String graph = compiler.dumpTriples();
						resPage = resPage.replace("$GRAPH", escapeHtml(graph));
					} catch (TypeException e) {
						throw new UserInputError("Type exception in the grammar:\n"+e.what);
					}
						
				}
				else
					throw new UserInputError("Incorrect sentence.");
			}
			catch(InputException e)
			{
				throw new UserInputError("Invalid input sentence:\n"+e.what);
			}
			
			return resPage;
		}
		catch(UserInputError e)
		{
			System.out.println("User input error");
			errPage = errPage.replace("$ERROR", e.what);
			return errPage;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return errPage;
		}
	}
	
	public WebApp()
	{
		super();
		try
		{
			homePage = readFile("www/index.html");
			errorPage = readFile("www/error.html");
			resultPage = readFile("www/process.html");
		}
		catch(IOException e)
		{
			homePage = "Error while loading the web pages.";
		}
		
		org.apache.jena.atlas.logging.Log.setLog4j();
		
		sem = new SemanticLexicon();
		sem.load("semantics.xml");
		
		tagger = new StanfordTagger();
		tagger.load("taggers/english-left3words-distsim.tagger");
	}
	
	public static void main(String[] list) throws Exception
	{
	      Container container = new WebApp();
	      Server server = new ContainerServer(container);
	      Connection connection = new SocketConnection(server);
	      SocketAddress address = new InetSocketAddress(8080);

	      connection.connect(address);
	      
	}

	private String readFile( String file ) throws IOException {
	    BufferedReader reader = new BufferedReader( new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");

	    while( ( line = reader.readLine() ) != null ) {
	        stringBuilder.append( line );
	        stringBuilder.append( ls );
	    }
	    reader.close();
	    return stringBuilder.toString();
	}

}
