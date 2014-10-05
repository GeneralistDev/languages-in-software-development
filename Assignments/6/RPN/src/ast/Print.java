package ast;

import machine.PCodeVisitor;
import parser.Token;

public class Print extends PCode{
	private String fMessage;
	
	public Print(Token aInstruction, Token aMessage) {
		super(aInstruction);
		
		fEndLine = aMessage.endLine;
		fEndColumn = aMessage.endColumn;
		
		fMessage = aMessage.image.subSequence(1, aMessage.image.length() - 1).toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append( "print\t" );
		sb.append( fMessage );
		return sb.toString();
	}
	
	public String getMessage() {
		return fMessage;
	}
	
	@Override
	public void accept(PCodeVisitor aVisitor) {
		aVisitor.visit(this);
	}
}
