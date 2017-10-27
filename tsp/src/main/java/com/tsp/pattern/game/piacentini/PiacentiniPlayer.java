package com.tsp.pattern.game.piacentini;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PiacentiniPlayer {

	private List<PiacentiniCard> hand = new LinkedList<>();
	private List<PiacentiniCard> score = new ArrayList<>();
	private Random random = new Random();

	private String name;

	public PiacentiniPlayer(String name) {
		this.setName(name);
	}

	public void addToHand(PiacentiniCard card) {
		hand.add(card);
	}

	public boolean isHandEmpty() {
		return hand.isEmpty();
	}

	public PiacentiniCard drop() {
		if (hand.isEmpty()) {
			return null;
		}
		int i = hand.size() > 1 ? random.nextInt(hand.size() - 1) : 0;
		PiacentiniCard card = hand.get(i);
		hand.remove(card);
		return card;
	}

	public PiacentiniPlayer addToScore(PiacentiniCard card) {
		score.add(card);
		return this;
	}

	public List<PiacentiniCard> getScore() {
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
		for (PiacentiniCard s : score) {
			tot += s.getValue().getValue();
		}
		return tot;
	}

}
