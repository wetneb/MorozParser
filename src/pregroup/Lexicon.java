package pregroup;

import java.util.List;
import org.apache.commons.lang3.tuple.Pair;


//! A interface mapping words to their set of type candidates
public interface Lexicon
{
	//! Retrieve the list of types for a given sentence
	public List<List<TypeString>> types(List<Pair<String,String>> sentence);
	
	//! Retrieve a comparator for the basic types
	public PartialComparator<String> getComparator();
}
