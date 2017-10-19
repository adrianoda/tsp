package com.tsp.pattern.doundo.memento;

public class Memento {

	private String colorValue;

	public Memento(String value) {
		this.colorValue = value;
	}

	public String getColorValue() {
		return colorValue;
	}

	public void setColorValue(String colorValue) {
		this.colorValue = colorValue;
	}
	
}
