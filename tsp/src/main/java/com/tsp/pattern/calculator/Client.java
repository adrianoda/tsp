package com.tsp.pattern.calculator;

public class Client {

	public static void main(String[] args) {
		String expression = "13 sum 2 sum 10";

		InterpreterInterface interpreter = parse(expression);

		float res = interpreter.interpret();
		System.out.println(expression + " = " + res);
	}

	private static InterpreterInterface parse(String expression) {
		String[] e = expression.split(" ");
		return build(e, null, 0);
	}

	private static InterpreterInterface build(String[] e, NumberInterpreter n, int i) {
		if (i >= e.length) {
			return n;
		}
		if ("sum".equals(e[i])) {
			return new SumInterpreter(n, build(e, n, ++i));
		} else {
			return build(e, new NumberInterpreter(Long.valueOf(e[i])), ++i);
		}
	}

}
