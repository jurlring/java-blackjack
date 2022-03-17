# java-blackjack

## BlackJackGame

- [x] 게임을 시작한다 (Dealer ,Player 등록)
- [x] 플레이어의 배팅 금액을 입력 받는다.
- [x] Player에게 최초 카드 2장을 준다.
- [x] Dealer가 카드를 받을 수 있으면 준다.
- [x] Gamer에게 카드를 줄지/ 안줄지 묻고 카드를 준다.
- [ ] 최종 수익을 계산한다

## Player <Interface>

- [x] 카드를 받는다
- [x] 카드를 오픈한다.
- [x] 보유하고 있는 카드 전체를 반환한다.
- [x] 보유하고 있는 카드의 점수를 계산한다.
- [x] 더 받을 수 있는 조건인지 확인한다.

### Dealer

- [x] Cards
- [x] 보유하고 있는 카드를 보여준다.
- [x] 카드를 받는다.
- [x] 카드를 1장만 공개한다.

### Gamer

- [x] Cards
- [x] name
- [x] 보유하고 있는 카드를 보여준다.
- [x] 카드를 받는다
- [x] [Error] 동일한 이름이 들어오면 예외를 발생시킨다. - Gamers 검증
- [x] [Error] 이름이 공백인 경우 예외를 발생시킨다. - 생성자 검증
- [x] [Error] 이름이 null인 경우 예외를 발생시킨다. - 생성자 검증
- [x] [Error] 이름이 "딜러"인경우 예외를 발생시킨다. - 생성자 검증

## Deck

- [x] 52장의 카드를 갖고 있다.
- [x] 카드를 뽑는다.
- [x] [Error] 카드가 0장이면 예외를 발생시킨다.

## Cards

- [x] 카드를 저장한다.
- [x] 카드의 합을 계산한다.

## Card

- [x] Enum - Denomination
- [x] Enum - Suit

## Answer

- [x] [Error] y/ n 중 입력이 없으면 예외를 발생시킨다.

## GameResult

- [ ] Gamers의 게임 결과를 계산한다.
- [ ] Dealer의 게임 결괴를 계산한다.

## BetMoney
- [x] [Error] 배팅금액이 음수일 경우 예외를 발생 시킨다.