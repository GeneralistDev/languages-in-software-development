package ast;

import machine.PCodeVisitor;
import parser.Token;

public class PCodeNumber extends PCodeArgument{
	private Double fValue;
	
	public PCodeNumber(Token aNumber) {
		fBeginLine = aNumber.beginLine;
		fBeginColumn = aNumber.beginColumn;
		fEndLine = aNumber.endLine;
		fEndColumn = aNumber.endColumn;
		
		fValue = Double.parseDouble(aNumber.image);
	}

	public Double getValue() {
		return fValue;
	}
	
	@Override
	public String toString() {
		return fValue.toString();
	}

	@Override
	public Double accept(PCodeVisitor aVisitor) {
		return aVisitor.visit(this);
	}
}
