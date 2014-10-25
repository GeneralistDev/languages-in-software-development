package ast;

public class FunctionType extends LambdaType {

	private LambdaType fType1;
	private LambdaType fType2;
	
	public LambdaType getType1() {
		return fType1;
	}
	
	public LambdaType getType2() {
		return fType2;
	}
	
	public FunctionType( LambdaType aType1, LambdaType aType2) {
		fType1 = aType1;
		fType2 = aType2;
	}
	
	@Override
	public boolean match(LambdaType aOtherType) {
		if (aOtherType instanceof FunctionType) {
			if (((FunctionType) aOtherType).getType1().match(fType1) &&
				((FunctionType)aOtherType).getType2().match(fType2)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "(" + fType1.toString() + " -> " + fType2.toString() + ")";
	}
}
