package com.tsp.pattern.doundo.command;

import com.tsp.pattern.doundo.memento.CareTaker;

public abstract class AbstractCommand {

	protected CareTaker careTaker;

	public AbstractCommand(CareTaker careTaker) {
		this.careTaker = careTaker;
	}

	public abstract void execute();

}
