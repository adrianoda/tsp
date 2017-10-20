package com.tsp.pattern.calculator;

public class SumInterpreter implements InterpreterInterface {
	
	public InterpreterInterface left;
	public InterpreterInterface right;
	
	public SumInterpreter(InterpreterInterface left, InterpreterInterface right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public float interpret() {
		return left.interpret() + right.interpret();
		
	}

}
