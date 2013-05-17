package xmllexicon;

import java.util.List;

import pregroup.TypeString;
import tagging.StanfordTagger;

public class TagLexicon extends XmlLexicon
{
	private static final long serialVersionUID = 1L;
	
	public List<List<TypeString>> types(List<String> sentence, StanfordTagger tagger)
	{
		return types(tagger.tagSentence(sentence));
	}
}
