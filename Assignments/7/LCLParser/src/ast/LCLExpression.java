package ast;

import java.util.Hashtable;
import java.util.Set;

public abstract class LCLExpression {
	public abstract Set<String> freeNames();
	
	public abstract LCLExpression substitute( String aVar, LCLExpression aExp );
	
	public abstract LCLExpression reduce( Hashtable<String, LCLExpression> aSymTable );
	
	public abstract String toString();
}
