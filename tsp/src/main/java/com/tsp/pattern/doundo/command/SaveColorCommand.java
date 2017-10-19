package com.tsp.pattern.doundo.command;

import com.tsp.pattern.doundo.memento.CareTaker;

public class SaveColorCommand extends AbstractCommand {

	public SaveColorCommand(CareTaker careTaker) {
		super(careTaker);
	}

	@Override
	public void execute() {
		careTaker.saveColor();
	}

}
