## 게임진행
1. 플레이어들의 이름을 입력받는다.
   -> View 객체가 필요
   -> 이름객체, 플레이어, 플레이어들 객체가 필요할 듯
- [x] 각 플레이어들의 배팅 금액을 입력받는다. 
2. 게임이 시작된다. 카드가 셔풀된다.
   -> 게임이 시작초기화를 어떻게 해줄 것인가? 컨트롤러에서 해줄 것인지, 도메인에 만들 것인지(Facade가 될까?)
   -> 카드라는 객체와 해당 카드가 셔플되어 deck으로 존재해야 한다.

3. 게임의 참가자는 딜러와 플레이어들이다.
   -> 딜러 객체도 필요
   -> 딜러와 플레이어는 게임의 참가자라는 공통점을 가진다.

4. 참가자 모두에게 카드 2장이 배부된다.
   -> 참가자는 카드들을 가지고 있어야 한다. Cards 라는 객체가 생기고 그것을 가지고 있다.
   -> 카드deck에서는 카드가 소진된다.

5. 참가자 전원의 카드 내역을 보여준다.
   -> 참가자의 카드내역을 View에게 넘겨주어야 한다. (DTO)

6. 플레이어들에게 돌아가며 한명씩 카드를 더 받을 것인지 묻는다. (받을 수 없거나 안 받을 때까지 반복)
   -> View와 섞여있는 로직 (플레이어의 카드내역을 전달: DTO)
   -> 플레이어 각각이 카드를 더 받을 수 있는 상태인지 알아야 한다. 카드를 받는 상태, 안 받는 상태가 존재함.

    6-1. 대답 'y' : 카드 합계가 21이하인지 확인
    -> 플레이어 각각이 카드 합계를 알아야 한다.
    6-2. 대답 'n' : 차례가 종료

7. 딜러의 카드 합계가 16이하이면 1장 배부한다.
   -> 딜러도 카드를 받는 상태와 안 받는 상태가 존재함
   -> 카드 합계 계산이 가능해야 함

8. 참가자 전원의 카드 내역 및 점수를 공개한다.
   -> DTO를 사용하여 참가자 전원의 카드 내역 및 점수정보를 전달

9. 참가자 전원의 승패여부를 보여준다.
   -> 참가자는 각자 승패여부를 알고 있어야 한다.
   -> DTO를 사용하여 해당 정보를 넘긴다.

- [x] 참가자들의 최종 수익을 보여준다.
   - [x] 딜러는 기본금 0원으로 셋팅되어 있다.
     
   **배팅금액 * 1.0**
   - [x] 딜러가 21을 초과하면 모든 플레이어들은 배팅 금액을 돌려받는다. 
   - [x] 딜러와 플레이어 모두 블랙잭이면 배팅 금액을 돌려받는다. 
   - [x] 무승부인 경우
     
   **배팅금액 * 0.0**
   - [x] 플레이어가 21을 초과하면 배팅 금액을 모두 잃는다.
   - [x] 진 경우    
    
   **배팅금액 * 1.5**
   - [x] 플레이어가 블랙잭인 경우 1.5배를 돌려받는다.
   - [x] 이긴 경우
   

## 추가 반영 필요사항
- [x] split View에서 해서 넘겨주기
- [x] 정규표현식 util에 지정해 놓기
- [x] 하나씩 선언하는 것
- [x] ! 사용하지 않기
- [x] boolean 리턴은 간소화
- [x] 기본 타입의 경우는 Wrapper 클래스에서 비교 메서드를 제공. compareTo 제거
- [x] 승패로직에서 각종 상수와 비교하는 구문들을 별도의 메서드로 추출
- [ ] 승패로직에서 Player를 인자로 넘겨주기
- [x] 딜러의 수익 결과 출력
- [x] 딜러 이름 상수화
- [x] emptyCards 상수화, BettingMoney(0) -> Player