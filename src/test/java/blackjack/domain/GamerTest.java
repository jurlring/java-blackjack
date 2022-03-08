package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GamerTest {

    @Test
    @DisplayName("이름이 딜러인경우 예외를 발생시킨다.")
    void createGamerExceptionNameDealer() {
        assertThatThrownBy(()-> new Gamer("딜러"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] Gamer의 이름은 딜러일 수 없습니다.");
    }

    @Test
    @DisplayName("카드를 받아 저장한다.")
    void getTwoCardsAtFirst() {
        Gamer gamer = new Gamer("judy");
        gamer.receiveCard(new Card(Suit.CLOVER, Denomination.FIVE));

        assertThat(gamer.cards().size()).isEqualTo(1);
    }
}
