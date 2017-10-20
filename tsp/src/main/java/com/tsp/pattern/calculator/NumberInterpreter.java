package com.tsp.pattern.calculator;

public class NumberInterpreter implements InterpreterInterface {
	
	float value;
	
	public NumberInterpreter(float value) {
		this.value = value;
	}

	@Override
	public float interpret() {
		return value;
	}

}
