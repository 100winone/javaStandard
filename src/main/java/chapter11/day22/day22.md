### 💡Day21 컬렉션 프레임웍 - Stack과 Queue
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/100winone/javaStandard

#### Stack과 Queue
- Stack : LIFO(Last In First Out)
  - 순차적으로 데이터를 추가하고 삭제하기 때문에 ArrayList가 적합
- Queue : FIFO(First In Last Out)
  - 첫 번째 데이터를 삭제하므로 데이터 추가/삭제가 쉬운 LinkedList로 구현하는것이 적합
  

> 스택은 Stack클래스로 구현하여 제공하지만, 큐는 Queue인터페이스로만 정의해놓고 별도의 클래스를 제공하지 않음. But. Queue인터페이스를 구현한 클래스들중 하나를 사용하면 됨

```