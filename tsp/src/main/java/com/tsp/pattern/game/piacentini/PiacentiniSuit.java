package com.tsp.pattern.game.piacentini;

public class PiacentiniSuit {

	public final static PiacentiniSuit DENARI = new PiacentiniSuit("denari");
	public final static PiacentiniSuit BASTONI = new PiacentiniSuit("bastoni");
	public final static PiacentiniSuit SPADE = new PiacentiniSuit("spade");
	public final static PiacentiniSuit COPPE = new PiacentiniSuit("coppe");

	private String suit;

	private PiacentiniSuit(String suit) {
		this.suit = suit;
	}

	@Override
	public String toString() {
		return suit;
	}

}
