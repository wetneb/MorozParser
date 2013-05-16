package xmllexicon;

import java.util.ArrayList;
import java.util.List;

import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.ling.Word;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import pregroup.TypeString;

public class TagLexicon extends XmlLexicon
{
	private static final long serialVersionUID = 1L;
	private MaxentTagger tagger = null;
	
	public void loadTagger(String path)
	{
		tagger = new MaxentTagger(path);
	}
	
	public List<List<TypeString>> types(List<String> sentence)
	{
		List<List<TypeString>> res = new ArrayList<List<TypeString>>();
		
		if(tagger != null)
		{
			List<Word> inputSentence = new ArrayList<Word>();
			for(String word : sentence)
				inputSentence.add(new Word(word));
			
			List<TaggedWord> taggedSentence = tagger.tagSentence(inputSentence);
			for(TaggedWord tw : taggedSentence)
			{
				System.out.println(tw.word() + " : " + tw.tag());
				List<TypeString> l = get(tw.tag());
				if(l == null)
					res.add(new ArrayList<TypeString>());
				else res.add(l);
			}
			return res;
		}
		else return null;
	}
	
}
