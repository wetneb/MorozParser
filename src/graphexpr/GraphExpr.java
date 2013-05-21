package graphexpr;

import pregroup.SimpleType;


public abstract class GraphExpr implements Cloneable
{
	public boolean isProducer() { return (this instanceof ProducerExpr); }
	public boolean isConsumer() { return (this instanceof ConsumerExpr); }
	
	public abstract SimpleType getType();
	
	public abstract Object clone();
}

