package blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class Cards {

	private final List<Card> cards;

	public Cards() {
		cards = new ArrayList<>();
	}

	public void save(final Card card) {
		cards.add(card);
	}

	public List<Card> getCards() {
		return List.copyOf(cards);
	}

	public int calculateTotalPoint() {
		int point = sumDenominationPoint();

		for (Card card : cards) {
			point = calculateAceAsSmallerStandard(point, card);
		}
		return point;
	}

	private int sumDenominationPoint() {
		return cards.stream()
			.mapToInt(card -> card.getDenomination().getPoint())
			.sum();
	}

	private int calculateAceAsSmallerStandard(int point, final Card card) {
		if (card.isAce() && point > Gamer.LIMIT_GAMER_TOTAL_POINT) {
			point -= Denomination.adjustAce();
		}
		return point;
	}
}
