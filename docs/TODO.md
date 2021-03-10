## 할 일
- 리팩토링

<br/>

## 완료한 일
- 현재 존재하는 Cards 클래스를 아예 더미로 보고, Cards 라는 일급 컬렉션을 따로 만들어야 하는지 고민해보기
- 딜러에서 16이하인 경우 카드 받는 기능 구현 중
- Controller 구현
- View 구현
  - Dealer, Users 이름 함께 출력하기
  - 추상 클래스에 name 추가하기
- 로직 수정
  - ACE(현재는 11)는 21을 초과할 때만 1로 변경
  - 카드 총합이 21을 초과하면 무조건 패

<br/>

## 정의
- Deck: 52개 만들기 + 52개 저장
- Cards: 일급 컬렉션
- ResultBoard: User 가 Dealer 에 대해 승/무/패 했는지 저장하는 Map