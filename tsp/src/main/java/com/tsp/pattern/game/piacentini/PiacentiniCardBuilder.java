package com.tsp.pattern.game.piacentini;

import java.util.HashMap;
import java.util.Map;

import com.tsp.pattern.game.Value;

public class PiacentiniCardBuilder extends PiacentiniCard {
	
	private static PiacentiniCardBuilder piacentiniCardBuilder;

	private PiacentiniCardBuilder() {
	}

	public static PiacentiniCardBuilder getInstance() {
		if (piacentiniCardBuilder == null) {
			return new PiacentiniCardBuilder();
		} else {
			return piacentiniCardBuilder;
		}
	}

	Map<String, PiacentiniCard> pool = new HashMap<>();

	public PiacentiniCard createCard(PiacentiniSuit suit, Value value) {
		String key = suit.toString() + value.toString();
		if (pool.containsKey(key)) {
			return pool.get(key);
		} else {
			PiacentiniCard card = new PiacentiniCard(suit, value);
			pool.put(key, card);
			return card;
		}
	}

}
