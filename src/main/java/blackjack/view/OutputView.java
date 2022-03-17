package blackjack.view;

import static java.util.stream.Collectors.joining;

import blackjack.domain.GameResult;
import blackjack.domain.card.Card;
import blackjack.domain.player.Dealer;
import blackjack.domain.player.Gamer;
import blackjack.domain.player.Player;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String PRINT_OPEN_CARD_PREFIX_MESSAGE = "\n%s와 ";
    private static final String PRINT_OPEN_CARD_SUFFIX_MESSAGE = "에게 2장의 카드를 나누었습니다.\n";
    private static final String PRINT_JOINING_DELIMITER = ", ";
    private static final String PRINT_DEFAULT_FORMAT_MESSAGE = "%s: %s\n";
    private static final String PRINT_SHOW_CARD_FORMAT_MESSAGE = "%s카드: %s\n";
    private static final String PRINT_DEALER_RECEIVE_CARD = "\n딜러는 16이하라 한장의 카드를 더 받았습니다.\n";
    private static final String PRINT_DEALER_NOT_RECEIVE_CARD = "\n딜러는 17이상이라 한장의 카드를 더 받지 못했습니다.\n";
    private static final String PRINT_FINAL_CARD_RESULT = "%s카드: %s - 결과: %d\n";
    private static final String FINAL_RESULT_MESSAGE = "\n## 최종 승패";

    public static void printErrorMessage(final String message) {
        System.out.println(message);
    }

    public static void printOpenCards(final List<Gamer> gamers, final Player dealer) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(PRINT_OPEN_CARD_PREFIX_MESSAGE, Dealer.DEALER_NAME))
            .append(joinNames(gamers))
            .append(PRINT_OPEN_CARD_SUFFIX_MESSAGE);

        appendDealerFormat(dealer, stringBuilder);
        appendGamerFormat(gamers, stringBuilder);

        System.out.println(stringBuilder);
    }

    private static String joinNames(final List<Gamer> gamers) {
        return gamers.stream()
            .map(Gamer::getName)
            .collect(joining(PRINT_JOINING_DELIMITER));
    }

    private static void appendDealerFormat(final Player dealer, final StringBuilder stringBuilder) {
        List<Card> cards = dealer.openCards();
        stringBuilder.append(
            String.format(PRINT_DEFAULT_FORMAT_MESSAGE, Dealer.DEALER_NAME, joinCards(cards)));
    }

    private static String joinCards(final List<Card> cards) {
        return cards.stream()
            .map(Card::getName)
            .collect(joining(PRINT_JOINING_DELIMITER));
    }

    private static void appendGamerFormat(final List<Gamer> gamers,
        final StringBuilder stringBuilder) {
        for (Gamer gamer : gamers) {
            stringBuilder.append(String.format(PRINT_SHOW_CARD_FORMAT_MESSAGE,
                gamer.getName(),
                joinCards(gamer.openCards())));
        }
    }

    public static void printGamerCards(final Gamer gamer) {
        System.out.printf(PRINT_SHOW_CARD_FORMAT_MESSAGE,
            gamer.getName(),
            joinCards(gamer.showCards()));
    }

    public static void printDealerReceive(final boolean receivable) {
        if (receivable) {
            System.out.println(PRINT_DEALER_RECEIVE_CARD);
            return;
        }
        System.out.println(PRINT_DEALER_NOT_RECEIVE_CARD);
    }

    public static void printFinalResult(final Player dealer, final List<Gamer> gamers) {
        printDealerCardsResult(dealer);
        gamers.forEach(OutputView::printGamerCardsResult);
    }

    private static void printDealerCardsResult(final Player dealer) {
        System.out.printf(PRINT_FINAL_CARD_RESULT,
            Dealer.DEALER_NAME,
            joinCards(dealer.showCards()),
            dealer.calculateResult());
    }

    private static void printGamerCardsResult(final Gamer gamer) {
        System.out.printf(PRINT_FINAL_CARD_RESULT,
            gamer.getName(),
            joinCards(gamer.showCards()),
            gamer.calculateResult());
    }

    public static void printFinalResultBoard(final Map<Gamer, GameResult> gamerResultBoard,
        int dealerResult) {
        System.out.println(FINAL_RESULT_MESSAGE);

        System.out.printf(PRINT_DEFAULT_FORMAT_MESSAGE, Dealer.DEALER_NAME, dealerResult);
        gamerResultBoard.forEach((key, value) -> System.out.printf(PRINT_DEFAULT_FORMAT_MESSAGE,
            key.getName(),
            (int)(key.BetMoney() * value.getMultiplePoint())));
    }


}
