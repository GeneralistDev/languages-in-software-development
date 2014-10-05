package ast;

import machine.PCodeVisitor;
import parser.Token;

public abstract class PCode extends Position {
	public PCode( Token aInstruction ) {
		fBeginLine = aInstruction.beginLine;
		fBeginColumn = aInstruction.beginColumn;
		fEndLine = aInstruction.endLine;
		fEndColumn = aInstruction.endColumn;
	}
	
	public abstract String toString();
	
	public abstract void accept( PCodeVisitor aVisitor );
}
