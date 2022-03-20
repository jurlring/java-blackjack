package blackjack.domain.player;

import blackjack.domain.BetMoney;
import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
import java.util.ArrayList;
import java.util.List;

public class Gamer extends Player {

    private static final int LIMIT_GAMER_TOTAL_POINT = 21;
    private static final int GAMER_OPEN_CARDS_SIZE = 2;

    private final String name;
    private final BetMoney betMoney;

    public Gamer(final String name, final int betMoney) {
        super(new Cards());
        checkName(name);
        this.name = name;
        this.betMoney = new BetMoney(betMoney);
    }

    private void checkName(final String name) {
        checkNullName(name);
        checkEmptyName(name);
        checkBannedName(name);
    }

    private void checkNullName(final String name) {
        if (name == null) {
            throw new IllegalArgumentException("[ERROR] Gamer의 이름은 null일 수 없습니다.");
        }
    }

    private void checkEmptyName(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] Gamer의 이름은 공백일 수 없습니다.");
        }
    }

    private void checkBannedName(final String name) {
        if (name.equals(Dealer.DEALER_NAME)) {
            throw new IllegalArgumentException("[ERROR] Gamer의 이름은 딜러일 수 없습니다.");
        }
    }

    @Override
    public List<Card> openCards() {
        return new ArrayList<>(cards.getCards().subList(0, GAMER_OPEN_CARDS_SIZE));
    }

    @Override
    public boolean isReceivable() {
        return calculateResult() < LIMIT_GAMER_TOTAL_POINT;
    }

    public String getName() {
        return name;
    }

    public long getBetMoney() {
        return betMoney.getBetMoney();
    }

}
