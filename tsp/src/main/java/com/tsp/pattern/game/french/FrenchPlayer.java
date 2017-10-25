package com.tsp.pattern.game.french;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class FrenchPlayer {

	private List<FrenchCard> hand = new LinkedList<>();
	private List<FrenchCard> score = new ArrayList<>();
	private Random random = new Random();

	private String name;

	public FrenchPlayer(String name) {
		this.setName(name);
	}

	public void addToHand(FrenchCard card) {
		hand.add(card);
	}

	public boolean isHandFull() {
		return hand.size() >= 3;
	}

	public boolean isHandEmpty() {
		return hand.isEmpty();
	}

	public FrenchCard drop() {
		if (hand.isEmpty()) {
			return null;
		}
		int i = hand.size() > 1 ? random.nextInt(hand.size() - 1) : 0;
		FrenchCard card = hand.get(i);
		hand.remove(card);
		return card;
	}

	public FrenchPlayer addToScore(FrenchCard card) {
		score.add(card);
		return this;
	}

	public List<FrenchCard> getScore() {
		return score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public int getTotalScore() {
		int tot = 0;
		for (FrenchCard s : score) {
			tot += s.getValue().getValue();
		}
		return tot;
	}

}
