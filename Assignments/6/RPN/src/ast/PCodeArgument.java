package ast;

import machine.PCodeVisitor;

public abstract class PCodeArgument extends Position{
	public abstract String toString();
	
	public abstract Double accept( PCodeVisitor aVisitor );
}
