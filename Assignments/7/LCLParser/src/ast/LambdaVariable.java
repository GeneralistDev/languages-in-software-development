package ast;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class LambdaVariable extends LCLExpression{
	private String fValue;
	
	public LambdaVariable( String aVariable ) {
		fValue = aVariable;
	}

	@Override
	public Set<String> freeNames() {
		HashSet<String> Result = new HashSet<String>();
		Result.add(fValue);
		return Result;
	}

	@Override
	public LCLExpression substitute( String aVar, LCLExpression aExp ) {
		if (fValue.equals(aVar)) {
			return aExp;
		} else {
			return this;
		}
	}

	@Override
	public String toString() {
		return fValue;
	}

	@Override
	public LCLExpression reduce(Hashtable<String, LCLExpression> aSymTable) {
		if (aSymTable.containsKey(fValue)) {
			LCLExpression lExpression = aSymTable.get(fValue);
			return lExpression;
		} else {
			throw new RuntimeException("Error reducing " + fValue + ", symbol not found");
		}
	}
}
