package com.tsp.pattern.game.french;

public class FrenchGame {

	private final FrenchPlayer p1;
	private final FrenchPlayer p2;
	private final FrenchDeck deck;
	private final FrenchSuit briscolSuit;
	private FrenchCard briscolCard;

	public FrenchGame(FrenchPlayer p1, FrenchPlayer p2) {
		this.p1 = p1;
		this.p2 = p2;

		// Create a new deck
		FrenchDeckBuilder db = new FrenchDeckBuilder();
		deck = db.createDeck();
		System.out.println(deck);

		// Distribute 3 cards for each player
		distribute(deck, p1);
		distribute(deck, p2);

		// Then set up the briscol
		briscolCard = deck.getCard();
		briscolSuit = briscolCard.getSuit();
		System.out.println("Briscol: " + briscolCard.toString());
	}

	public void play() {
		FrenchPlayer winner = p1;
		FrenchPlayer looser = p2;
		FrenchPlayer tmp;
		while (!deck.isEmpty() || !p1.isHandEmpty() || !p1.isHandEmpty()) {
			// Each player play a card
			FrenchCard c1 = winner.drop();
			FrenchCard c2 = looser.drop();
			System.out.println("winner " + winner + " play " + c1 + " - looser " + looser + " play " + c2);

			// Choose the winner and switch state
			int win = drop(c1, c2);
			if (win == -1) {
				tmp = winner;
				winner = looser;
				looser = tmp;
			}
			System.out.println("wins " + winner);

			// Add cards to winner score dsk
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
		// Last card to be picked up is the briscola card
		if (deck.isEmpty() && briscolCard != null) {
			deck.addCard(briscolCard);
			briscolCard = null;
		}
		// Fill player hand
		while (!deck.isEmpty() && !player.isHandFull()) {
			player.addToHand(deck.getCard());
		}
	}

	private int drop(FrenchCard c1, FrenchCard c2) {
		if (c1 == null) {
			return -1;
		} else if (c2 == null) {
			return 1;
		}
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
