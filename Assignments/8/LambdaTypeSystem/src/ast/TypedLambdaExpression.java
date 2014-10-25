package ast;

import java.util.Hashtable;

public abstract class TypedLambdaExpression {
	public abstract LambdaType typeCheck( Hashtable<String, LambdaType> aGamma );
	public abstract String toString();
}