package ast;

import java.util.Set;
import java.util.HashSet;

public class IfThenElse extends LCLExpression {
	
	private LCLExpression fCondition;
	private LCLExpression fThen;
	private LCLExpression fElse;
	
	public IfThenElse( LCLExpression aCondition, LCLExpression aThen, LCLExpression aElse ){
		fCondition = aCondition;
		fThen = aThen;
		fElse = aElse;
	}
	
	public LCLExpression getCondition() {
		return fCondition;
	}
	
	public LCLExpression getThen() {
		return fThen;
	}
	
	public LCLExpression getElse() {
		return fElse;
	}
	
	@Override
	public Set<String> freeNames() {
		Set<String> Result = new HashSet<String>( fCondition.freeNames() );
		Result.addAll( fThen.freeNames() );
		Result.addAll( fElse.freeNames() );
		
		return Result;
	}

	@Override
	public LCLExpression substitute(String aVar, LCLExpression aExp) {
		return new IfThenElse( fCondition.substitute( aVar, aExp ),
								fThen.substitute(aVar, aExp),
								fElse.substitute(aVar, aExp));
	}

	@Override
	public String toString() {
		return "(if " + fCondition.toString() + " " + fThen.toString() + " " + fElse.toString() + ")";
	}
}
