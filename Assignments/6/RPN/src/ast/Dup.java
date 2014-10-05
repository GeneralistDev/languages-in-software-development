package ast;

import machine.PCodeVisitor;
import parser.Token;

public class Dup extends PCode {
	Token fToken;
	
	public Dup(Token aInstruction) {
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
