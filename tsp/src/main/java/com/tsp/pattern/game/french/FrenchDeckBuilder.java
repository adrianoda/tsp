package com.tsp.pattern.game.french;

import com.tsp.pattern.game.Value;

public class FrenchDeckBuilder {

	private static FrenchDeckBuilder frenchDeckBuilder;

	private FrenchDeckBuilder() {
	}

	public static FrenchDeckBuilder getInstance() {
		if (frenchDeckBuilder == null) {
			frenchDeckBuilder = new FrenchDeckBuilder();
		}
		return frenchDeckBuilder;
	}

	private FrenchSuit[] suits = { FrenchSuit.CUORI, FrenchSuit.FIORI, FrenchSuit.PICCHE, FrenchSuit.QUADRI };
	private Value[] values = { Value.ASSO, Value.CAVALLO, Value.CINQUE, Value.DUE, Value.FANTE, Value.QUATTRO, Value.RE,
			Value.SEI, Value.SETTE, Value.TRE };

	public FrenchDeck createDeck() {
		FrenchCardBuilder cardBuilder = FrenchCardBuilder.getInstance();
		FrenchDeck deck = new FrenchDeck();
		for (FrenchSuit s : suits) {
			for (Value v : values) {
				FrenchCard card = cardBuilder.createCard(s, v);
				deck.addCard(card);
			}
		}
		return deck;
	}

}
