package ast;

import java.util.Hashtable;

public class LambdaVariable extends TypedLambdaExpression{
	private String fVariable;
	
	public LambdaVariable( String aVariable ) {
		fVariable = aVariable;
	}

	@Override
	public LambdaType typeCheck(Hashtable<String, LambdaType> aGamma) {
		if (aGamma.containsKey(fVariable)) {
			return aGamma.get(fVariable);
		} else {
			throw new RuntimeException(fVariable + " is not contained in the type environment");
		}
	}

	@Override
	public String toString() {
		return fVariable;
	}
}
