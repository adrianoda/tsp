package com.tsp.pattern.doundo;

import com.tsp.pattern.doundo.command.AbstractCommand;
import com.tsp.pattern.doundo.command.SaveColorCommand;
import com.tsp.pattern.doundo.command.UndoColorCommand;
import com.tsp.pattern.doundo.memento.CareTaker;
import com.tsp.pattern.doundo.memento.Color;

public class Client {

	public static void main(String[] args) {
		Color color = new Color();
		CareTaker careTaker = new CareTaker(color);
		AbstractCommand save = new SaveColorCommand(careTaker);
		AbstractCommand undo = new UndoColorCommand(careTaker);

		// Set color
		color.setValue("RED");
		System.out.println(color);
		
		// Set color and save
		color.setValue("BLUE");
		System.out.println(color);
		save.execute();
		
		// Set color
		color.setValue("BLACK");
		System.out.println(color);
		
		// Restore color
		undo.execute();
		System.out.println(color);
	}

}
