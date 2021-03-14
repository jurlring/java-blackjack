package blakcjack.domain.participant;

import blakcjack.domain.card.Cards;
import blakcjack.domain.card.Deck;
import blakcjack.domain.name.Name;

import java.util.Objects;

public abstract class Participant {
	protected final Name name;
	protected final Cards cards = new Cards();

	protected Participant(final Name name) {
		this.name = name;
	}

	public Cards getCards() {
		return cards;
	}

	public void drawOneCardFrom(Deck deck) {
		cards.add(deck.pop());
	}

	public String getName() {
		return name.getName();
	}

	public int getScore() {
		return cards.calculateScore();
	}

	public boolean isBust() {
		return cards.isBust();
	}

	public Cards getHand() {
		return cards;
	}

	public boolean isDealer() {
		return this instanceof Dealer;
	}

	public boolean isBlackJack() {
		return cards.isBlackjack();
	}

	public abstract Cards getInitialHand();

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Participant that = (Participant) o;
		return Objects.equals(name, that.name) && Objects.equals(cards, that.cards);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, cards);
	}
}