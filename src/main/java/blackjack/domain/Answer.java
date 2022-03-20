package blackjack.domain;

import java.util.Arrays;

public enum Answer {

    HIT("y"),
    STAY("n");

    private final String answer;

    Answer(final String answer) {
        this.answer = answer;
    }

    private static Answer of(final String input) {
        return Arrays.stream(values())
            .filter(value -> value.getAnswer().equals(input.toLowerCase()))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 응답입니다."));
    }

    public static boolean isHit(String answer) {
        return HIT == of(answer);
    }

    private String getAnswer() {
        return answer;
    }
}
