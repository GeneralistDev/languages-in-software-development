package machine;

import ast.*;

public interface PCodeVisitor {
	public void visit( Add aInstruction );
	public void visit( Sub aInstruction );
	public void visit( Mul aInstruction );
	public void visit( Div aInstruction );
	public void visit( Dup aInstruction );
	public void visit( Print aInstruction );
	public void visit( Load aInstruction );
	public void visit( Store aInstruction );

	public Double visit( PCodeVariable aArgument );
	public Double visit( PCodeNumber aArgument );
}
