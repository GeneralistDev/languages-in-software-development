package ast;

import parser.Token;

public class PCodeVariable extends PCodeArgument{
	private String fVariableName;
	
	public PCodeVariable(Token aVariable) {
		fBeginLine = aVariable.beginLine;
		fBeginColumn = aVariable.beginColumn;
		fEndLine = aVariable.endLine;
		fEndColumn = aVariable.endColumn;
		
		fVariableName = aVariable.image;
	}

	public String getValue() {
		return fVariableName;
	}
	
	@Override
	public String toString() {
		return getValue();
	}
}