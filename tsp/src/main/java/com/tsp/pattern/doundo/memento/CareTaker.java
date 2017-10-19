package com.tsp.pattern.doundo.memento;

import java.util.Stack;

public class CareTaker {

	private Color color;
	private Stack<Memento> mementos;

	public CareTaker(Color color) {
		this.color = color;
		this.mementos = new Stack<>();
	}

	public void saveColor() {
		System.out.println("Saving color " + color.getValue() + "...");
		mementos.push(color.createMemento());
	}

	public void undoColor() {
		if (!mementos.isEmpty()) {
			System.out.println("Undo color...");
			color.applyMemento(mementos.pop());
		}
	}

}
