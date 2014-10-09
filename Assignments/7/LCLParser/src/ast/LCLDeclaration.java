package ast;

import java.util.Set;

public class LCLDeclaration extends LCLExpression{
	private String fLabel;
	private LCLExpression fExpression;
	
	public String getVariable() {
		return fLabel;
	}
	
	public LCLExpression getExpression() {
		return fExpression;
	}
	
	public LCLDeclaration( String aLabel, LCLExpression aExpression ) {
		fLabel = aLabel;
		fExpression = aExpression;
	}
	
	@Override
	public Set<String> freeNames() {
		return fExpression.freeNames();
	}

	@Override
	public LCLExpression substitute(String aVar, LCLExpression aExp) {
		return new LCLDeclaration( fLabel, fExpression.substitute(aVar, aExp));
	}

	@Override
	public String toString() {
		return "(define " + fLabel + " " + fExpression.toString() + ")"; 
	}
}
