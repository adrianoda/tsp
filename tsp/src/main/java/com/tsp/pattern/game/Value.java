package com.tsp.pattern.game;

public class Value {

	public final static Value ASSO = new Value("asso", 10);
	public final static Value TRE = new Value("tre", 9);
	public final static Value RE = new Value("re", 8);
	public final static Value CAVALLO = new Value("cavallo", 7);
	public final static Value FANTE = new Value("fante", 6);
	public final static Value SETTE = new Value("sette", 5);
	public final static Value SEI = new Value("sei", 4);
	public final static Value CINQUE = new Value("cinque", 3);
	public final static Value QUATTRO = new Value("quattro", 2);
	public final static Value DUE = new Value("due", 1);

	private String name;
	private Integer value;

	private Value(String name, Integer value) {
		this.name = name;
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	@Override
	public String toString() {
		return name;
	}

}
