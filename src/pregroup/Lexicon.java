package pregroup;

import java.util.List;

//! A interface mapping words to their set of type candidates
public interface Lexicon<BT extends BasicType<BT>>
{
	//! Retrieve the list of types for a given word
	public List<TypeString<BT>> types(String word);
	
}
