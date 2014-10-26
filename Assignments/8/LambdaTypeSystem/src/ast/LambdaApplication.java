package ast;

import java.util.Hashtable;

public class LambdaApplication extends TypedLambdaExpression{

	private TypedLambdaExpression fFunction;
	private TypedLambdaExpression fArgument;
	
	public LambdaApplication( TypedLambdaExpression aFunction, 
								TypedLambdaExpression aArgument ) {
		fFunction = aFunction;
		fArgument = aArgument;
	}
	
	@Override
	public LambdaType typeCheck(Hashtable<String, LambdaType> aGamma) {
		LambdaType lArgumentType = fArgument.typeCheck(aGamma);
		
		LambdaType lFunction = fFunction.typeCheck(aGamma);
		
		if (lFunction instanceof FunctionType) {
			if (((FunctionType)lFunction).getType1().match(lArgumentType)){
				return ((FunctionType)lFunction).getType2();
			} else {
				throw new RuntimeException(fFunction.toString() + 
						" parameter type does not match argument type " + fArgument );
			}
		} else {
			throw new RuntimeException("Function type expected for '" + fFunction + "'");
		}
	}

	@Override
	public String toString() {
		return "(" + fFunction + " " + fArgument + ")";
	}
}
