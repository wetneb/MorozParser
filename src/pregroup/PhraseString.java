package pregroup;

import java.util.List;
import java.util.Vector;

interface PhraseElem
{
	public String toString();
	public boolean isType();
	public boolean isLB();
	public boolean isRB();
	public boolean isStar();
}

class TypeElem<BT extends BasicType<BT>> implements PhraseElem
{
	public SimpleType<BT> val;
	
	public String toString() { return val.toString(); }
	public boolean isType() { return true; }
	public boolean isLB() { return false; }
	public boolean isRB() { return false; }
	public boolean isStar() { return false; }
}

class StarElem implements PhraseElem
{
	public String toString() { return " * "; }
	public boolean isType() { return false; }
	public boolean isLB() { return false; }
	public boolean isRB() { return false; }
	public boolean isStar() { return true; }
}

class LBElem implements PhraseElem
{
	public String toString() { return " < "; }
	public boolean isType() { return false; }
	public boolean isLB() { return true; }
	public boolean isRB() { return false; }
	public boolean isStar() { return false; }
}

class RBElem implements PhraseElem
{
	public String toString() { return " > "; }
	public boolean isType() { return false; }
	public boolean isLB() { return false; }
	public boolean isRB() { return true; }
	public boolean isStar() { return false; }
}

//! A string made of simple types, *, < and >
public class PhraseString<BT extends BasicType<BT>> extends Vector<PhraseElem>
{
	private static final long serialVersionUID = 1L;
	
	// Construct from a list of words, a lexicon and a target type
	public PhraseString(Lexicon<BT> lex, List<String> lst, TypeString<BT> target)
	{
		this(LexMap.map(lex, lst), target);
	}

	// Construct from a list of type candidates and a target type
	public PhraseString(List<List<TypeString<BT>>> lst, TypeString<BT> target)
	{
		for(List<TypeString<BT>> candidates : lst)
		{
			addLB();
			addStar();
			for(TypeString<BT> type : candidates)
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
	
	public PhraseString(Lexicon<BT> lex, List<String> sentence,
			SimpleType<BT> target) {
		this(lex,sentence,new TypeString<BT>(target));
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
	
	private void addLB()
	{
		this.add(new LBElem());
	}
	
	private void addRB()
	{
		this.add(new RBElem());
	}
	
	private void addStar()
	{
		this.add(new StarElem());
	}
	
	private void addType(SimpleType<BT> t)
	{
		TypeElem<BT> elem = new TypeElem<BT>();
		elem.val = t;
		add(elem);
	}
	
	private void addType(TypeString<BT> lst)
	{
		for(SimpleType<BT> t : lst)
			addType(t);
	}
}
