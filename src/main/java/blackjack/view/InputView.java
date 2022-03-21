package blackjack.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String REQUEST_BETTING_MONEY_MESSAGE = "\n%s의 배팅 금액은?\n";
    private static final String REQUEST_PLAYER_NAME_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String DELIMITER = ",";
    private static final String INPUT_BLANK = " ";
    private static final String INPUT_NOT_BLANK = "";
    private static final String REQUEST_PLAYER_ANSWER_MESSAGE = "%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)\n";
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> requestPlayerName() {
        System.out.println(REQUEST_PLAYER_NAME_MESSAGE);

        return Arrays.stream(scanner.nextLine().split(DELIMITER))
            .map(InputView::removeBlank)
            .collect(Collectors.toList());
    }

    private static String removeBlank(final String name) {
        return name.replaceAll(INPUT_BLANK, INPUT_NOT_BLANK);
    }

    public static String requestAnswer(final String name) {
        System.out.printf(REQUEST_PLAYER_ANSWER_MESSAGE, name);
        return scanner.nextLine();
    }

    public static int requestBettingMoney(final String name) {
        System.out.printf(REQUEST_BETTING_MONEY_MESSAGE, name);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception) {
            System.out.println("[ERROR] 배팅 금액은 숫자를 입력하셔야 합니다.");
            return requestBettingMoney(name);
        }
    }
}
