package ast;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class NotZero extends LCLExpression {
	private String fVariable;
	
	public String getVariable() {
		return fVariable;
	}
	
	public NotZero( String aVariable ) {
		fVariable = aVariable;
	}

	@Override
	public Set<String> freeNames() {
		return new HashSet<String>();
	}

	@Override
	public LCLExpression reduce(Hashtable<String, LCLExpression> aSymTable) {
		if ( aSymTable.contains( getVariable() )) {
			if ( aSymTable.get( getVariable() ) instanceof LambdaNumber ) {
				LambdaNumber lNumber = (LambdaNumber)aSymTable.get(getVariable());
				if (lNumber.getNumber() == 0) {
					return new LambdaNumber("0");
				} else {
					return new LambdaNumber("1");
				}
			} else {
				throw new ArithmeticException("Variable not a number" + getVariable());
			}
		} else {
			throw new RuntimeException("No symbol mapping for " + getVariable());
		}
	}
	
	@Override
	public LCLExpression substitute(String aVar, LCLExpression aExp) {
		return this;
	}

	@Override
	public String toString() {
		return "notZero(" + fVariable + ")";
	}

}
