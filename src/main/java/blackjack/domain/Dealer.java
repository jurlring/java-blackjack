package blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class Dealer implements Player{

    public static final String DEALER_NAME = "딜러";

    private static final int DEALER_RECEIVE_STANDARD = 16;

    private final Cards cards;

    public Dealer() {
        cards = new Cards();
    }

    @Override
    public void receiveCard(final Card card) {
        cards.save(card);
    }

    @Override
    public List<Card> openCards() {
        return new ArrayList<>(cards.getCards().subList(0, 1));
    }

    @Override
    public List<Card> showCards() {
        return cards.getCards();
    }

    @Override
    public int calculateResult() {
        return cards.calculateTotalPoint();
    }

    @Override
    public boolean isReceivable() {
        return calculateResult() <= DEALER_RECEIVE_STANDARD;
    }



}
