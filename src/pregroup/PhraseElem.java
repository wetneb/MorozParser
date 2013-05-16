package pregroup;

public interface PhraseElem
{
	public String toString();
	public String toLatex();
	public boolean isType();
	public boolean isLB();
	public boolean isRB();
	public boolean isStar();
}
class TypeElem implements PhraseElem
{
	public SimpleType val;
	
	public String toString() { return val.toString(); }
	public String toLatex() { return val.toLatex(); }
	public boolean isType() { return true; }
	public boolean isLB() { return false; }
	public boolean isRB() { return false; }
	public boolean isStar() { return false; }
}

class StarElem implements PhraseElem
{
	public String toString() { return " * "; }
	public String toLatex() { return toString(); }
	public boolean isType() { return false; }
	public boolean isLB() { return false; }
	public boolean isRB() { return false; }
	public boolean isStar() { return true; }
}

class LBElem implements PhraseElem
{
	public String toString() { return " < "; }
	public String toLatex() { return toString(); }
	public boolean isType() { return false; }
	public boolean isLB() { return true; }
	public boolean isRB() { return false; }
	public boolean isStar() { return false; }
}
class RBElem implements PhraseElem
{
	public String toString() { return " > "; }
	public String toLatex() { return toString(); }
	public boolean isType() { return false; }
	public boolean isLB() { return false; }
	public boolean isRB() { return true; }
	public boolean isStar() { return false; }
}

