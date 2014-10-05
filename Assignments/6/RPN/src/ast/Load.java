package ast;

import parser.Token;

public class Load extends PCode {
	private PCodeArgument fArgument;
	
	public Load(Token aInstruction, PCodeArgument aArgument ) {
		super(aInstruction);
		
		fArgument = aArgument;
		
		this.fEndColumn = aArgument.fBeginColumn;
		this.fEndLine = aArgument.fEndLine;
	}
	
	public PCodeArgument getArgument() {
		return fArgument;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append( "load\t" );
		sb.append( fArgument.toString() );
		
		return sb.toString();
	}
}
