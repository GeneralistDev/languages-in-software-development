package ast;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class LambdaApplication extends LCLExpression {
	private LCLExpression fFunction;
	private LCLExpression fArgument;
	
	public LCLExpression getFunction() {
		return fFunction;
	}
	
	public LCLExpression getArgument() {
		return fArgument;
	}
	
	public LambdaApplication( LCLExpression aFunction, LCLExpression aArgument) {
		fFunction = aFunction;
		fArgument = aArgument;
	}

	@Override
	public Set<String> freeNames() {
		Set<String> Result = new HashSet<String>(fFunction.freeNames());
		Result.addAll(fArgument.freeNames());
		
		return Result;
	}

	@Override
	public LCLExpression substitute(String aVar, LCLExpression aExp) {
		return new LambdaApplication( fFunction.substitute(aVar, aExp),
										fArgument.substitute(aVar, aExp));
	}

	@Override
	public String toString() {
		return "( " + fFunction.toString() + " " + fArgument.toString() + " )";
	}

	@Override
	public LCLExpression reduce(Hashtable<String, LCLExpression> aSymTable) {
		LCLExpression lArgument = fArgument.reduce(aSymTable);
		LCLExpression lFunction = fFunction.reduce(aSymTable);
		
		if (lFunction instanceof LambdaFunction) {
			LambdaFunction lLambdaFunction = (LambdaFunction)lFunction;
			LCLExpression subExpression = lLambdaFunction.substitute(lLambdaFunction.getVariable(), lArgument);
			return subExpression.reduce(aSymTable);
		} else {
			return new LambdaApplication(lFunction, lArgument);
		}
	}
}
