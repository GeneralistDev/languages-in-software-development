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
		return this;
	}
	
	@Override
	public LCLExpression substitute(String aVar, LCLExpression aExp) {
		if ( getVariable().equals(aVar) ) {
			if ( aExp instanceof LambdaNumber ) {
				LambdaNumber lNumber = (LambdaNumber)aExp;
				if (lNumber.getNumber() == 0) {
					return new LambdaNumber("0");
				} else {
					return new LambdaNumber("1");
				}
			} else {
				throw new ArithmeticException( "Illegal argument: " + aExp );
			}
		} else {
			return this;
		}
	}

	@Override
	public String toString() {
		return "notZero(" + fVariable + ")";
	}

}
