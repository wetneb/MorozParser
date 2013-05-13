package xmllexicon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import pregroup.FreeType;
import pregroup.Lexicon;
import pregroup.TypeString;


public class XmlLexicon
	extends HashMap<String, List<TypeString<FreeType>>>
	implements Lexicon<FreeType>
{
	private static final long serialVersionUID = 1L;

	public List<List<TypeString<FreeType>>> types(List<String> sentence)
	{
		List<List<TypeString<FreeType>>> res = new ArrayList<List<TypeString<FreeType>>>();
		for(String word : sentence)
		{
			List<TypeString<FreeType>> l = get(word);
			if(l == null)
				res.add(new ArrayList<TypeString<FreeType>>());
			else res.add(l);
		}
		return res;
	}
	
	public void load(String filename)
	{
		try {
		JAXBContext jaxbContext;
			jaxbContext = JAXBContext
					.newInstance("xmllexicon");
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		JAXBElement<?> lexicon = (JAXBElement<?>)unmarshaller
				.unmarshal(new FileInputStream(filename));
		
		RawLexicon rl = (RawLexicon)lexicon.getValue();
		Entries entries = rl.getEntries();
		TypeRelations rels = rl.getRelations();
		
		//! TODO : add error handling ! (if entries.getEntry() is null (when there's no <entries>)
		for(EntryType ent : entries.getEntry()) {
			String form = ent.getForm();
			List<String> rawTypes = ent.getType();
			List<TypeString<FreeType>> res = new ArrayList<TypeString<FreeType>>();
			
			for(String rt : rawTypes)
				res.add(SimpleTypeParser.parse(rt, rels));
			
			put(form, res);
		}
		
		} catch (JAXBException je) {
			je.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
}
