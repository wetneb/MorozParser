package pregroup;

import java.util.List;
import java.util.ArrayList;

public class LexMap
{
	public static<BT extends BasicType<BT>>
	List<List<TypeString<BT>>> map(Lexicon<BT> lex, List<String> lst)
	{
		List<List<TypeString<BT>>> res = new
				ArrayList<List<TypeString<BT>>>();
		for(String w : lst)
		{
			res.add(lex.types(w));
		}
		return res;
	}
}
