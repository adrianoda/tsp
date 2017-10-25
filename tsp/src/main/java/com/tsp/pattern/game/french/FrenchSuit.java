package com.tsp.pattern.game.french;

public class FrenchSuit {
	
	public final static FrenchSuit QUADRI = new FrenchSuit("quadri");
	public final static FrenchSuit CUORI = new FrenchSuit("cuori");
	public final static FrenchSuit PICCHE = new FrenchSuit("picche");
	public final static FrenchSuit FIORI = new FrenchSuit("fiori");

	private String suit;

	private FrenchSuit(String suit) {
		this.suit = suit;
	}

	@Override
	public String toString() {
		return suit;
	}

}
