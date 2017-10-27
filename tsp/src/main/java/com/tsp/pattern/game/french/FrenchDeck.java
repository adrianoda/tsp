package com.tsp.pattern.game.french;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

public class FrenchDeck {

	private List<FrenchCard> deck;

	public FrenchDeck() {
		deck = new LinkedList<>();
	}

	public void addCard(FrenchCard card) {
		deck.add(card);
	}

	public FrenchCard setupBriscol() {
		FrenchCard briscol = pullCard();
		deck.add(0, briscol);
		return briscol;
	}

	public FrenchCard pullCard() {
		if (!isEmpty()) {
			int i = deck.size() - 1;
			FrenchCard card = deck.get(i);
			deck.remove(i);
			return card;
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
