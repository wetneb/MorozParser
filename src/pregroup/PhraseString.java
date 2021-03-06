package pregroup;

import java.util.List;
import java.util.Vector;

import org.apache.commons.lang3.tuple.Pair;

//! A string made of simple types, *, < and >
public class PhraseString extends Vector<PhraseElem>
{
	private static final long serialVersionUID = 1L;
	
	// Construct an empty phrase string
	public PhraseString()
	{
		
	}
	
	// Construct from a list of words, a lexicon and a target type
	public PhraseString(Lexicon lex, List<Pair<String,String>> lst, TypeString target)
	{
		this(lex.types(lst), target);
	}

	// Construct from a list of type candidates and a target type
	public PhraseString(List<List<TypeString>> lst, TypeString target)
	{
		for(List<TypeString> candidates : lst)
		{
			addLB();
			addStar();
			for(TypeString type : candidates)
			{
				addType(type);
				addStar();
			}
			
			addRB();
		}
		
		//! Add the candidate
		addLB();
		addStar();
		addType(target.right());
	}
	
	public PhraseString(Lexicon lex, List<Pair<String,String>> sentence,
			SimpleType target) {
		this(lex,sentence,new TypeString(target));
	}
	

	public String toString()
	{
		String res = "";
		for(PhraseElem e : this)
		{
			res += e.toString();
		}
		return res;
	}
	
	protected void addLB()
	{
		this.add(new LBElem());
	}
	
	protected void addRB()
	{
		this.add(new RBElem());
	}
	
	protected void addStar()
	{
		this.add(new StarElem());
	}
	
	private void addType(SimpleType t)
	{
		TypeElem elem = new TypeElem();
		elem.val = t;
		add(elem);
	}
	
	protected void addType(TypeString lst)
	{
		for(SimpleType t : lst)
			addType(t);
	}
}
