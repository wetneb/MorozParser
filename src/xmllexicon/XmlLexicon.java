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

import org.apache.commons.lang3.tuple.Pair;

import pregroup.Lexicon;
import pregroup.PartialComparator;
import pregroup.TypeString;


public class XmlLexicon
	implements Lexicon
{
	private HashMap<String, List<TypeString>> mFromTag;
	private HashMap<String, List<TypeString>> mFromForm;
	
	private TypeRelations rels;

	public List<List<TypeString>> types(List<Pair<String,String>> sentence)
	{
		List<List<TypeString>> res = new ArrayList<List<TypeString>>();
		for(Pair<String,String> word : sentence)
		{
			List<TypeString> l = mFromForm.get(word.getLeft());
			if(l == null)
			{
				List<TypeString> l2 = mFromTag.get(word.getRight());
				if(l2 == null)
					res.add(new ArrayList<TypeString>());
				else
					res.add(l2);
			}
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
			String tag = ent.getTag();
			
			List<String> rawTypes = ent.getType();
			List<TypeString> res = new ArrayList<TypeString>();
			
			for(String rt : rawTypes)
				res.add(SimpleTypeParser.parse(rt));
			
			if(form != "" && form != null)
				mFromForm.put(form, res);
			else
				mFromTag.put(tag, res);
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
