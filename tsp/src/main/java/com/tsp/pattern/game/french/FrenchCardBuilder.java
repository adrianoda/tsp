package com.tsp.pattern.game.french;

import java.util.HashMap;
import java.util.Map;

import com.tsp.pattern.game.Value;

public class FrenchCardBuilder extends FrenchCard {

	private static FrenchCardBuilder frenchCardBuilder;

	private FrenchCardBuilder() {
	}

	public static FrenchCardBuilder getInstance() {
		if (frenchCardBuilder == null) {
			return new FrenchCardBuilder();
		} else {
			return frenchCardBuilder;
		}
	}

	private Map<String, FrenchCard> pool = new HashMap<>();

	public FrenchCard createCard(FrenchSuit suit, Value value) {
		String key = suit.toString() + value.toString();
		if (pool.containsKey(key)) {
			return pool.get(key);
		} else {
			FrenchCard card = new FrenchCard(suit, value);
			pool.put(key, card);
			return card;
		}
	}

}
