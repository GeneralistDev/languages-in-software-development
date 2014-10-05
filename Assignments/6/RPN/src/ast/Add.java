package ast;

import machine.PCodeVisitor;
import parser.Token;

public class Add extends PCode {
	Token fToken;
	
	public Add(Token aInstruction) {
		super(aInstruction);
		
		fToken = aInstruction;
	}

	@Override
	public String toString() {
		return fToken.image.toString(); 
	}

	@Override
	public void accept(PCodeVisitor aVisitor) {
		aVisitor.visit(this);
	}
}
