package pregroup;

public interface PhraseElem
{
	public String toString();
	public String toLatex();
	public boolean isType();
	public boolean isLB();
	public boolean isRB();
	public boolean isStar();
	
	public boolean isProducer();
	public boolean isS();
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
	
	public boolean isProducer() { return val.isProductive(); }
	public boolean isS() { return val.getBase().equals("s"); }
}

class StarElem implements PhraseElem
{
	public String toString() { return " * "; }
	public String toLatex() { return toString(); }
	public boolean isType() { return false; }
	public boolean isLB() { return false; }
	public boolean isRB() { return false; }
	public boolean isStar() { return true; }
	
	public boolean isProducer() { return false; }
	public boolean isS() { return false; }
}

class LBElem implements PhraseElem
{
	public String toString() { return " < "; }
	public String toLatex() { return toString(); }
	public boolean isType() { return false; }
	public boolean isLB() { return true; }
	public boolean isRB() { return false; }
	public boolean isStar() { return false; }
	
	public boolean isProducer() { return false; }
	public boolean isS() { return false; }
}
class RBElem implements PhraseElem
{
	public String toString() { return " > "; }
	public String toLatex() { return toString(); }
	public boolean isType() { return false; }
	public boolean isLB() { return false; }
	public boolean isRB() { return true; }
	public boolean isStar() { return false; }
	
	public boolean isProducer() { return false; }
	public boolean isS() { return false; }
}

