package ast;

import java.util.Hashtable;

public class LambdaApplication extends TypedLambdaExpression{

	public LambdaApplication( TypedLambdaExpression aFunction, TypedLambdaExpression aArgument ) {
		
	}
	
	@Override
	public LambdaType typeCheck(Hashtable<String, LambdaType> aGamma) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
