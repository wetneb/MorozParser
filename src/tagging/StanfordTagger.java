package tagging;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.ling.Word;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class StanfordTagger
{
	private MaxentTagger tagger = null;
	
	public StanfordTagger()
	{
		
	}
	
	public void load(String path)
	{
		tagger = new MaxentTagger(path);
	}
	
	public List<Pair<String,String>> tagSentence(List<String> sentence)
	{
		List<Pair<String,String>> result = new ArrayList<Pair<String,String>>();
		List<Word> inputSentence = new ArrayList<Word>();
		for(String word : sentence)
			inputSentence.add(new Word(word));
		
		List<TaggedWord> taggedSentence = tagger.tagSentence(inputSentence);
		for(TaggedWord tw : taggedSentence)
			result.add(Pair.of(tw.word(), tw.tag()));
		
		return result;
	}
}
