package ast;

import java.util.Set;
import java.util.HashSet;
import java.util.Hashtable;

public class Increment extends LCLExpression {
	private String fVariable;
	
	public String getVariable() {
		return fVariable;
	}
	
	public Increment( String aVariable ) {
		fVariable = aVariable;
	}
	
	public Set<String> freeNames() {
		return new HashSet<String>();
	}
	
	public LCLExpression reduce( Hashtable<String,LCLExpression> aSymTable ) {
		return this;
	}
	
	public LCLExpression substitute( String aVar, LCLExpression aExp ) {
		if ( getVariable().equals( aVar ) ) {
			if ( aExp instanceof LambdaNumber ) {
				Integer lNumber = ((LambdaNumber)aExp).getNumber() + 1;
				return new LambdaNumber( lNumber.toString() );
			} else {
				throw new ArithmeticException( "Illegal argument: " + aExp );
			}
		} else {
			return this;
		}
	}
	
	public String toString() {
		return "incr(" + fVariable + ")";
	}
}