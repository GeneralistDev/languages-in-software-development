package ast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import parser.LCLParser;
import parser.ParseException;

public class LoadDeclaration extends LCLExpression {
	private String fUnitName;
	
	public String getUnitName() {
		return fUnitName;
	}
	
	public LoadDeclaration( String aUnitName ) {
		fUnitName = aUnitName;
		
		if ( !fUnitName.endsWith( ".lam" )) {
			fUnitName += ".lam";
		}
	}
	
	@Override
	public Set<String> freeNames() {
		return new HashSet<String>();
	}

	@Override
	public LCLExpression substitute(String aVar, LCLExpression aExp) {
		return this;
	}

	@Override
	public String toString() {
		return "(load \"" + fUnitName + "\")";
	}

	@Override
	public LCLExpression reduce(Hashtable<String, LCLExpression> aSymTable) {
		try {
			LCLParser lParser = new LCLParser(new FileInputStream(fUnitName));
			ArrayList<LCLExpression> LCLExpressions = lParser.CompilationUnit();
			
			LCLExpression lastExpression = null;
			
			for ( LCLExpression e: LCLExpressions ) {
				lastExpression = e.reduce(aSymTable);
			}
			
			return lastExpression;
			
		} catch (FileNotFoundException e) {
			throw new RuntimeException("The file '" + fUnitName + "' was not found.");
		} catch ( ParseException e ) {
			throw new RuntimeException("Syntax Error : \n"+ e.toString());
		}
	}
}
