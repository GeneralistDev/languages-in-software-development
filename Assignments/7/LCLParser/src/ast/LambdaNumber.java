package ast;

import java.util.Hashtable;
import java.util.Set;
import java.util.HashSet;

public class LambdaNumber extends LCLExpression {
	private Integer fNumber;
	
	public Integer getNumber() {
		return fNumber;
	}
	
	public LambdaNumber( String aNumber ) {
		fNumber = Integer.parseInt( aNumber );
	}
	
	@Override
	public Set<String> freeNames() {
		return new HashSet<String>();
	}

	@Override
	public LCLExpression substitute(String aVar, LCLExpression aExp) {
		return this;
	}

	@Override
	public String toString() {
		return fNumber.toString();
	}

	@Override
	public LCLExpression reduce(Hashtable<String, LCLExpression> aSymTable) {
		return this;
	}
}
