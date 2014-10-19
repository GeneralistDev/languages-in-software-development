package ast;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class Decrement extends LCLExpression {
	private String fVariable;
	
	public String getVariable() {
		return fVariable;
	}
	
	public Decrement( String aVariable ) {
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
				Integer lNumber = ((LambdaNumber)aExp).getNumber() - 1;
				return new LambdaNumber( lNumber.toString() );
			} else {
				throw new ArithmeticException("Illegal argument: " + aExp);
			}
		} else {
			return this;
		}
	}

	@Override
	public String toString() {
		return "decr(" + fVariable + ")";
	}
}
