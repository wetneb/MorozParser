package pregroup;

public class SimpleType<BT extends BasicType<BT>>
{
	private BT base;
	private int exp;
	
	public SimpleType(BT bt, int e)
	{
		base = bt;
		exp = e;
	}
	
	public boolean isUnit()
	{
		return base.isUnit();
	}
	
	//! Generalized Contraction rule
	public boolean gcon(SimpleType<BT> a)
	{
		return
				(a.exp == this.exp + 1) && 
				((this.base.lessThan(a.base) && this.exp % 2 == 0) ||
				 (a.base.lessThan(this.base) && this.exp % 2 != 0));
	}
	
	//! Left adjoint of the type
	public SimpleType<BT> left()
	{
		SimpleType<BT> adj = this;
		adj.exp--;
		return adj;
	}
	
	//! Right adjoint of the type
	public SimpleType<BT> right()
	{
		SimpleType<BT> adj = this;
		adj.exp++;
		return adj;
	}
	
	public String toString()
	{	
		if(exp == 0)
			return base.toString();
		
		return base.toString() + "^{" + exp + "}";
	}
}
