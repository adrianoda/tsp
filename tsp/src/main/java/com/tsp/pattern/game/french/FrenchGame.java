package com.tsp.pattern.game.french;

public class FrenchGame {

	public void play(FrenchPlayer p1, FrenchPlayer p2) {
		FrenchPlayer winner = p1;
		FrenchPlayer looser = p2;
		FrenchPlayer tmp;

		// Setup the game
		FrenchDeck deck = FrenchDeckBuilder.getInstance().createDeck();
		System.out.println(deck.toString());
		for (int i = 0; i < 3; i++) {
			distribute(deck, winner);
			distribute(deck, looser);
		}
		FrenchCard briscolCard = deck.setupBriscol();
		System.out.println("Briscol is: " + briscolCard.toString());

		while (!deck.isEmpty() || (!p1.isHandEmpty() && !p1.isHandEmpty())) {
			// Each player play a card
			FrenchCard c1 = winner.drop();
			FrenchCard c2 = looser.drop();
			System.out.println("winner " + winner + " play " + c1 + " - looser " + looser + " play " + c2);

			// Choose the winner and switch state
			int win = drop(c1, c2, briscolCard.getSuit());
			if (win == -1) {
				tmp = winner;
				winner = looser;
				looser = tmp;
			}
			System.out.println("wins " + winner);

			// Add cards to winner score deck
			winner.addToScore(c1).addToScore(c2);

			// Again, one card for each player
			distribute(deck, winner);
			distribute(deck, looser);
		}
		System.out.println(deck.toString());
		System.out.println("p1 deck size: " + p1.getScore().size() + ", total score: " + p1.getTotalScore());
		System.out.println("p2 deck size: " + p2.getScore().size() + ", total score: " + p2.getTotalScore());
	}

	private void distribute(FrenchDeck deck, FrenchPlayer player) {
		if (!deck.isEmpty()) {
			player.addToHand(deck.pullCard());
		}
	}

	private int drop(FrenchCard c1, FrenchCard c2, FrenchSuit briscolSuit) {
		if (c1.getSuit().toString().equals(c2.getSuit().toString())) {
			// same suit, the higher value the winner!
			return c1.getValue().getValue().compareTo(c2.getValue().getValue());
		} else if (c1.getSuit().toString().equals(briscolSuit.toString())) {
			// c1 is a briscol
			return 1;
		} else if (c2.getSuit().toString().equals(briscolSuit.toString())) {
			// c2 is a briscol
			return -1;
		}
		return 1;
	}

}
