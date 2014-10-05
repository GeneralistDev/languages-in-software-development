package ast;

import parser.Token;

public class Print extends PCode{
	public String fMessage;
	
	public Print(Token aInstruction, Token aMessage) {
		super(aInstruction);
		
		fEndLine = aMessage.endLine;
		fEndColumn = aMessage.endColumn;
		
		fMessage = aMessage.image.subSequence(1, aMessage.image.length() - 1).toString();
	}

	@Override
	public String toString() {
		return fMessage;
	}
}
