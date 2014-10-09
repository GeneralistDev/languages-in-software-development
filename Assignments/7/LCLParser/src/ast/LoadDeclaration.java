package ast;

import java.util.HashSet;
import java.util.Set;

public class LoadDeclaration extends LCLExpression {
	private String fUnitName;
	
	public String getUnitName() {
		return fUnitName;
	}
	
	public LoadDeclaration( String aUnitName ) {
		fUnitName = aUnitName;
		
		if ( !fUnitName.endsWith( ".lam" )) {
			fUnitName += ".lam";
		}
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
		return "(load \"" + fUnitName + "\")";
	}
}
