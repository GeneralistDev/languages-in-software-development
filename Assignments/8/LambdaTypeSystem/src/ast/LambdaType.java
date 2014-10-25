package ast;

public abstract class LambdaType {
	public abstract boolean match( LambdaType aOtherType );
	public abstract String toString();
}
