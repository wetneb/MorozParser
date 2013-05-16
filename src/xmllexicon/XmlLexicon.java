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

import pregroup.Lexicon;
import pregroup.PartialComparator;
import pregroup.TypeString;


public class XmlLexicon
	extends HashMap<String, List<TypeString>>
	implements Lexicon
{
	private static final long serialVersionUID = 1L;
	
	private TypeRelations rels;

	public List<List<TypeString>> types(List<String> sentence)
	{
		List<List<TypeString>> res = new ArrayList<List<TypeString>>();
		for(String word : sentence)
		{
			List<TypeString> l = get(word);
			if(l == null)
				res.add(new ArrayList<TypeString>());
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
		rels = rl.getRelations();
		
		//! TODO : add error handling ! (if entries.getEntry() is null (when there's no <entries>)
		for(EntryType ent : entries.getEntry()) {
			String form = ent.getForm();
			List<String> rawTypes = ent.getType();
			List<TypeString> res = new ArrayList<TypeString>();
			
			for(String rt : rawTypes)
				res.add(SimpleTypeParser.parse(rt));
			
			put(form, res);
		}
		
		} catch (JAXBException je) {
			je.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
	
	public PartialComparator<String> getComparator()
	{
		return rels;
	}
}
