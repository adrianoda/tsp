package com.tsp.pattern.game.french;

import java.util.Iterator;
import java.util.Stack;
import java.util.StringJoiner;

public class FrenchDeck {

	private Stack<FrenchCard> deck;

	public FrenchDeck() {
		deck = new Stack<>();
	}

	public void addCard(FrenchCard card) {
		deck.push(card);
	}

	public FrenchCard getCard() {
		if (!isEmpty()) {
			return deck.pop();
		} else {
			return null;
		}
	}

	public boolean isEmpty() {
		return deck.isEmpty();
	}

	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner("\n");
		sj.add("Deck size: " + deck.size());
		Iterator<FrenchCard> iterator = deck.iterator();
		while (iterator.hasNext()) {
			sj.add(iterator.next().toString());
		}
		return sj.toString();
	}

}
