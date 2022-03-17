package blackjack.domain;

import blackjack.domain.player.Gamer;
import blackjack.domain.player.Player;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public enum GameResult {
    BLACKJACK(1.5, (dealer, gamer) -> gamer.isBlackJack() && !dealer.isBlackJack()),

    WIN(1.0, (dealer, gamer) -> !isBurst(gamer)
        && (dealer.calculateResult() < gamer.calculateResult() || isBurst(dealer))
    ),
    DRAW(0.0, (dealer, gamer) -> !isBurst(gamer)
        && dealer.calculateResult() == gamer.calculateResult()
    ),
    LOSE(-1.0, (dealer, gamer) -> isBurst(gamer)
        || dealer.calculateResult() > gamer.calculateResult()
    );

    public static final int LIMIT_BLACK_JACK_POINT = 21;

    private final Double multiplePoint;
    private final BiPredicate<Player, Gamer> predicate;

    GameResult(final Double multiplePoint, final BiPredicate<Player, Gamer> predicate) {
        this.multiplePoint = multiplePoint;
        this.predicate = predicate;
    }

    private static boolean isBurst(Player player) {
        return player.calculateResult() > LIMIT_BLACK_JACK_POINT;
    }

    public static GameResult findResult(final Player dealer, final Gamer gamer) {
        return Arrays.stream(values())
            .filter((result) -> result.predicate.test(dealer, gamer))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하는 결과가 없습니다."));
    }

    public static Map<Gamer, GameResult> calculateGamersFinalResultBoard(final Player dealer,
        final List<Gamer> gamers) {
        return gamers.stream()
            .collect(Collectors.toMap(gamer -> gamer,
                gamer -> GameResult.findResult(dealer, gamer),
                (e1, e2) -> e1, LinkedHashMap::new));
    }

    public static int calculateDealerFinalResult(Map<Gamer, GameResult> gamerResult) {
        int dealerProfit = 0;
        for (Entry<Gamer, GameResult> gameResultEntry : gamerResult.entrySet()) {
            dealerProfit +=
                gameResultEntry.getKey().BetMoney() * - gameResultEntry.getValue().getMultiplePoint();
        }
        return dealerProfit;
    }

    public Double getMultiplePoint() {
        return multiplePoint;
    }
}
