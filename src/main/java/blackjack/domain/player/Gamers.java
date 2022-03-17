package blackjack.domain.player;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Gamers {

    private final List<Gamer> gamers;

    public Gamers(final List<Gamer> gamers) {
        this.gamers = gamers;
    }

    public static Gamers createGamers(final List<String> names, final Function<String, Integer> betMoney) {
        checkDuplicateName(names);
        List<Gamer> gamers = names.stream()
            .map(name -> new Gamer(name, betMoney.apply(name)))
            .collect(Collectors.toList());
        return new Gamers(gamers);
    }

    private static void checkDuplicateName(final List<String> names) {
        Set<String> removalDuplicateNames = new HashSet<>(names);
        if (names.size() != removalDuplicateNames.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름은 입력할 수 없습니다.");
        }
    }

    public List<Gamer> getGamers() {
        return gamers;
    }
}
