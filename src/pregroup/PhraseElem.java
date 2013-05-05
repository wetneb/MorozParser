package pregroup;

public interface PhraseElem
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
