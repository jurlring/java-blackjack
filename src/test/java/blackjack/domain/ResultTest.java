package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    @DisplayName("승리한 경우를 계산한다.")
    void findWinningResult() {
        Player dealer = new Dealer();
        dealer.receiveCard(new Card(Suit.DIAMOND, Denomination.FIVE));

        Gamer judy = new Gamer("judy");
        judy.receiveCard(new Card(Suit.CLOVER, Denomination.SIX));

        assertThat(Result.findResult(dealer.calculateResult()
                , judy.calculateResult())).isEqualTo(Result.WIN);
    }

    @Test
    @DisplayName("21이 넘어 패배한 경우를 계산한다.")
    void findLosingResultOverStandard() {
        Player dealer = new Dealer();
        dealer.receiveCard(new Card(Suit.DIAMOND, Denomination.FIVE));

        Gamer judy = new Gamer("judy");
        judy.receiveCard(new Card(Suit.CLOVER, Denomination.JACK));
        judy.receiveCard(new Card(Suit.DIAMOND, Denomination.JACK));
        judy.receiveCard(new Card(Suit.SPADE, Denomination.TWO));

        assertThat(Result.findResult(dealer.calculateResult()
                , judy.calculateResult())).isEqualTo(Result.LOSE);
    }

    @Test
    @DisplayName("패배한 경우를 계산한다.")
    void findLosingResult() {
        Player dealer = new Dealer();
        dealer.receiveCard(new Card(Suit.DIAMOND, Denomination.FIVE));

        Gamer judy = new Gamer("judy");
        judy.receiveCard(new Card(Suit.CLOVER, Denomination.FOUR));

        assertThat(Result.findResult(dealer.calculateResult()
                , judy.calculateResult())).isEqualTo(Result.LOSE);
    }

    @Test
    @DisplayName("무승부인 경우를 계산한다.")
    void findDrawResult() {
        Player dealer = new Dealer();
        dealer.receiveCard(new Card(Suit.DIAMOND, Denomination.FIVE));

        Gamer judy = new Gamer("judy");
        judy.receiveCard(new Card(Suit.CLOVER, Denomination.FIVE));

        assertThat(Result.findResult(dealer.calculateResult()
                , judy.calculateResult())).isEqualTo(Result.DRAW);
    }

}