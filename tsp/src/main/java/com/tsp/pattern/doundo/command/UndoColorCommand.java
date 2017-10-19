package com.tsp.pattern.doundo.command;

import com.tsp.pattern.doundo.memento.CareTaker;

public class UndoColorCommand extends AbstractCommand {

	public UndoColorCommand(CareTaker careTaker) {
		super(careTaker);
	}

	@Override
	public void execute() {
		careTaker.undoColor();
	}

}
