package pregroup;

import java.util.List;

//! A interface mapping words to their set of type candidates
public interface Lexicon
{
	//! Retrieve the list of types for a given sentence
	public List<List<TypeString>> types(List<String> word);
	
	//! Retrieve a comparator for the basic types
	public PartialComparator<String> getComparator();
}
