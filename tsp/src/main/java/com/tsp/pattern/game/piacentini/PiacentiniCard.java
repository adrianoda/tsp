package com.tsp.pattern.game.piacentini;

import com.tsp.pattern.game.Value;

public class PiacentiniCard {

	private PiacentiniSuit suit;
	private Value value;

	protected PiacentiniCard() {
	}

	protected PiacentiniCard(PiacentiniSuit suit, Value value) {
		this.suit = suit;
		this.value = value;
	}

	public PiacentiniSuit getSuit() {
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
