package machine;

import java.util.*;

import ast.Add;
import ast.Div;
import ast.Dup;
import ast.Load;
import ast.Mul;
import ast.PCodeNumber;
import ast.PCodeVariable;
import ast.Print;
import ast.Store;
import ast.Sub;

public class PCodeMachine implements PCodeVisitor {
	Stack< Double > fStack;
	Hashtable< String, Double > fMemory;
	
	public PCodeMachine() {
		fStack = new Stack< Double >();
		fMemory = new Hashtable< String, Double >();
	}
	
	public void printStackTrace() {
		System.out.println("Stack:");
		int i = 1;
		while (!fStack.empty()) {
			System.out.println(i + ":\t" + fStack.pop());
			i++;
		}
	}
	
	public void printMemoryTrace() {
		System.out.println("Memory:");
		for (String key: fMemory.keySet()) {
			System.out.println(key + ":\t" + fMemory.get(key));
		}
	}
	
	@Override
	public void visit(Add aInstruction) {
		Double result = fStack.pop() + fStack.pop();
		fStack.add(result);
	}

	@Override
	public void visit(Sub aInstruction) {
		Double result = fStack.pop() - fStack.pop();
		fStack.add(result);
	}

	@Override
	public void visit(Mul aInstruction) {
		Double result = fStack.pop() * fStack.pop();
		fStack.add(result);
	}

	@Override
	public void visit(Div aInstruction) {
		Double right = fStack.pop();
		Double left = fStack.pop();
		if (right == 0.0) {
			System.out.println( "Division by Zero, expression starting in line" + aInstruction.fBeginLine + " column" + aInstruction.fBeginColumn);
			System.exit(1);
		}
		Double result = left / right;
		fStack.add(result);
	}

	@Override
	public void visit(Dup aInstruction) {
		Double original = fStack.peek();
		fStack.push(original);
	}

	@Override
	public void visit(Print aInstruction) {
		System.out.println(aInstruction.getMessage() + fStack.pop());
	}

	@Override
	public void visit(Load aInstruction) {
		fStack.add(aInstruction.getArgument().accept(this));
	}

	@Override
	public void visit(Store aInstruction) {
		fMemory.put(aInstruction.getVariableName(), fStack.pop());
	}

	@Override
	public Double visit(PCodeVariable aArgument) {
		return fMemory.get(aArgument.getValue());
	}

	@Override
	public Double visit(PCodeNumber aArgument) {
		return aArgument.getValue();
	}

}
