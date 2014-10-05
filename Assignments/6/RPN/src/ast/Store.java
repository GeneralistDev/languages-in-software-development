package ast;

import parser.Token;

public class Store extends PCode {
	private String fVariableName;
	
	public Store(Token aInstruction, Token aVariable) {
		super(aInstruction);
		
		fEndLine = aVariable.endLine;
		fEndColumn = aVariable.endColumn;
		
		fVariableName = aVariable.image;
	}

	public String getVariableName() {
		return fVariableName;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append( "store\t" );
		sb.append( fVariableName );
		
		return sb.toString();
	}
}
