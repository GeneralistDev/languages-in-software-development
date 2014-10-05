package ast;

import parser.Token;

public class Sub extends PCode {
	Token fToken;
	
	public Sub(Token aInstruction) {
		super(aInstruction);
		
		fToken = aInstruction;
	}	
	
	@Override
	public String toString() {
		return fToken.image.toString(); 
	}
}
