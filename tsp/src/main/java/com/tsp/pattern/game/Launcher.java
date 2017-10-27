package com.tsp.pattern.game;

import com.tsp.pattern.game.french.FrenchGame;
import com.tsp.pattern.game.french.FrenchPlayer;

public class Launcher {

	public static void main(String[] args) {
		FrenchPlayer p1 = new FrenchPlayer("p1");
		FrenchPlayer p2 = new FrenchPlayerAdapter("p2");
		FrenchGame fg = new FrenchGame();
		fg.play(p1, p2);
	}

}
