package com.tsp.pattern.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tsp.pattern.game.french.FrenchCard;
import com.tsp.pattern.game.french.FrenchCardBuilder;
import com.tsp.pattern.game.french.FrenchPlayer;
import com.tsp.pattern.game.french.FrenchSuit;
import com.tsp.pattern.game.piacentini.PiacentiniCard;
import com.tsp.pattern.game.piacentini.PiacentiniCardBuilder;
import com.tsp.pattern.game.piacentini.PiacentiniPlayer;
import com.tsp.pattern.game.piacentini.PiacentiniSuit;

public class FrenchPlayerAdapter extends FrenchPlayer {

	private final PiacentiniPlayer piacentiniPlayer;
	private final PiacentiniCardBuilder pbuilder = PiacentiniCardBuilder.getInstance();
	private final FrenchCardBuilder fbuilder = FrenchCardBuilder.getInstance();
	private final Map<FrenchSuit, PiacentiniSuit> frenchToPiacentini = new HashMap<>();
	private final Map<PiacentiniSuit, FrenchSuit> piacentiniToFrench = new HashMap<>();

	public FrenchPlayerAdapter(String name) {
		super(name);
		piacentiniPlayer = new PiacentiniPlayer(name);
		frenchToPiacentini.put(FrenchSuit.CUORI, PiacentiniSuit.COPPE);
		frenchToPiacentini.put(FrenchSuit.PICCHE, PiacentiniSuit.SPADE);
		frenchToPiacentini.put(FrenchSuit.FIORI, PiacentiniSuit.BASTONI);
		frenchToPiacentini.put(FrenchSuit.QUADRI, PiacentiniSuit.DENARI);
		piacentiniToFrench.put(PiacentiniSuit.COPPE, FrenchSuit.CUORI);
		piacentiniToFrench.put(PiacentiniSuit.SPADE, FrenchSuit.PICCHE);
		piacentiniToFrench.put(PiacentiniSuit.BASTONI, FrenchSuit.FIORI);
		piacentiniToFrench.put(PiacentiniSuit.DENARI, FrenchSuit.QUADRI);
	}

	@Override
	public void addToHand(FrenchCard card) {
		piacentiniPlayer.addToHand(convert(card));
	}

	@Override
	public boolean isHandEmpty() {
		return piacentiniPlayer.isHandEmpty();
	}

	@Override
	public boolean isHandFull() {
		return piacentiniPlayer.isHandFull();
	}

	@Override
	public FrenchPlayer addToScore(FrenchCard card) {
		piacentiniPlayer.addToScore(convert(card));
		return this;
	}

	@Override
	public FrenchCard drop() {
		PiacentiniCard card = piacentiniPlayer.drop();
		return convert(card);
	}

	@Override
	public List<FrenchCard> getScore() {
		List<PiacentiniCard> pscore = piacentiniPlayer.getScore();
		List<FrenchCard> fscore = new ArrayList<>();
		for (PiacentiniCard card : pscore) {
			fscore.add(convert(card));
		}
		return fscore;
	}

	@Override
	public int getTotalScore() {
		List<FrenchCard> score = getScore();
		int tot = 0;
		for (FrenchCard s : score) {
			tot += s.getValue().getValue();
		}
		return tot;
	}

	@Override
	public String getName() {
		return piacentiniPlayer.getName();
	}

	private PiacentiniCard convert(FrenchCard card) {
		return pbuilder.createCard(frenchToPiacentini.get(card.getSuit()), card.getValue());
	}

	private FrenchCard convert(PiacentiniCard card) {
		return fbuilder.createCard(piacentiniToFrench.get(card.getSuit()), card.getValue());
	}

}
