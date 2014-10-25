package ast;

import java.util.Hashtable;

public class LambdaFunction extends TypedLambdaExpression {
	private String fVariable;
	private LambdaType fType;
	private TypedLambdaExpression fBody;
	
	public LambdaFunction( String aVariable, LambdaType aType, TypedLambdaExpression aBody ) {
		fVariable = aVariable;
		fType = aType;
		fBody = aBody;
	}

	@Override
	public LambdaType typeCheck(Hashtable<String, LambdaType> aGamma) {
		aGamma.put(fVariable, fType);
		return new FunctionType( fType, fBody.typeCheck(aGamma));
	}

	@Override
	public String toString() {
		return "(lambda " + fVariable + " " + fType.toString() + " " + fBody.toString() + ")";
	}
}
