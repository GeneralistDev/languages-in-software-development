package ast;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class LambdaFunction extends LCLExpression {
	private String fVariable;
	private LCLExpression fBody;
	
	public String getVariable() {
		return fVariable;
	}
	
	public LCLExpression getExpression() {
		return fBody;
	}
	
	public LambdaFunction( String aVariable, LCLExpression aBody) {
		fVariable = aVariable;
		fBody = aBody;
	}
	
	@Override
	public Set<String> freeNames() {
		Set<String> Result = new HashSet<String>(fBody.freeNames());
		Result.remove(getVariable());
		
		return Result;
	}

	@Override
	public LCLExpression substitute(String aVar, LCLExpression aExp) {
		if (getVariable().equals(aVar)) {
			return this;
		} else {
			Set<String> fFrees = aExp.freeNames();
			
			// Substitution Rule 6
			if ( fFrees.contains( getVariable() ) ) {
				String lFresh = fVariable + "%";
				while ( fFrees.contains( lFresh )){
					lFresh += "%";
				}
				
				LCLExpression lNewBody = fBody.substitute( fVariable, new LambdaVariable(lFresh));
				lNewBody.substitute(aVar, aExp);
				return new LambdaFunction(lFresh, lNewBody);
			} else {
				// Substitution Rule 5
				return new LambdaFunction( fVariable, fBody.substitute(aVar, aExp));
			}
		}
	}

	@Override
	public String toString() {
		return "(lambda " + fVariable + "." + fBody.toString() + ")";
	}

	@Override
	public LCLExpression reduce(Hashtable<String, LCLExpression> aSymTable) {
		return this;
	}

}
