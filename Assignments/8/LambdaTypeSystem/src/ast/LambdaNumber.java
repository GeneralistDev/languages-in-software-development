package ast;

import java.util.Hashtable;

public class LambdaNumber extends TypedLambdaExpression{
	private String fValue;
	
	public LambdaNumber( String aValue ) {
		fValue = aValue;
	}
	
	@Override
	public LambdaType typeCheck(Hashtable<String, LambdaType> aGamma) {
		return new IntegerType();
	}

	@Override
	public String toString() {
		return fValue;
	}
}
