package com.tsp.pattern.doundo.memento;

public class Color {

	private String value;

	public Memento createMemento() {
		return new Memento(value);
	}

	public void applyMemento(Memento memento) {
		this.value = memento.getColorValue();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Color [value=" + value + "]";
	}

}
