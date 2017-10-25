package com.tsp.pattern.game.french;

import com.tsp.pattern.game.Value;

public class FrenchCard {

	private FrenchSuit suit;
	private Value value;

	protected FrenchCard() {
	}

	protected FrenchCard(FrenchSuit suit, Value value) {
		this.suit = suit;
		this.value = value;
	}

	public FrenchSuit getSuit() {
		return suit;
	}

	public Value getValue() {
		return value;
	}

	@Override
	public String toString() {
		return suit.toString() + "-" + value.toString();
	}

}
