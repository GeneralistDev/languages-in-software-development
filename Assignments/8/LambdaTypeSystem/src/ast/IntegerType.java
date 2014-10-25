package ast;

public class IntegerType extends LambdaType {

	public IntegerType() { }
	
	@Override
	public boolean match(LambdaType aOtherType) {
		if (aOtherType instanceof IntegerType) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Int";
	}
}
