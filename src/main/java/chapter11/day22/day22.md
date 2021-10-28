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
스택의 활용 예 - 수식계산, 수식괄호검사, 워드프로세서의 undo/redo, 웹브라우저의 뒤로/앞으로
큐의 활용 예 - 최근사용문서, 인쇄작업 대기목록, 버퍼(buffer)
```

#### PriorityQueue
- Queue인터페이스의 구현체
- 저장한 순서에 관계없이 우선순위 높은 것부터 꺼내게됨
- null을 저장하게 되면 NullPointerException 발생
- 저장공간으로 배열을 사용하고, 각 요소를 힙(heap)이라는 자료구조 형태로 저장
- 숫자의 경우 작을수록 우선순위가 높음

#### Deque(Double-Ended Queue)
- 양쪽 끝에 추가/삭제 가능
- 조상은 Queue, 구현체로는 ArrayDeque와 LinkedList 등이 있음


|Deque|Queue|Stack|
|------|-------|------|
|offerLast()|offer()|push()|
|pollLast()|-|pop()|
|pollFirst()|poll()|-|
|peekFirst()|peek()|-|
|peekLast()|-|peek()|

#### Iterator, ListIterator, Enumeration
> 컬렉션에 저장된 요소를 접근하는데 사용되는 인터페이스
- 컬렉션에 저장된 각 요소에 접근하는 기능을 가진 Iterator인터페이스를 정의하고, Collection인터페이스에는 'Iterator'를 반환하는 iterator()를 정의

|메서드|설 명|
|------|-------|
|boolean hasNext()|읽어 올 요소가 남아있는지 확인. 있으면 true, 없으면 false반환|
|Object next()|다음 요소를 읽음. next()를 호출하기 전에 hasNext()를 호출해서 읽어 올 요소가 있는지 확인하는 것이 안전|
|void remove()|next()로 읽어 온 요소를 삭제. next()를 호출한 다음에 remove()를 호출해야함(선택적 기능)|

```java
List list = new ArrayList();
Iterator it = list.iterator();

while(it.hasNext()){
    System.out.println(it.next());
}
```

- Map인터페이스를 구현한 컬렉션 클래스는 키(key)와 값(value)을 쌍(pair)으로 저장하고 있기 때문에 keySet()이나 entrySet()과 같은 메서드를 통해 iterator()를 호출할 수 있음
```java
Map map = new HashMap();
Iterator it = map.keySet().iterator();

Iterator list = map.entrySet().iterator();
```

```
Enumeration  - iterator의 구버전
ListIterator - iterator에 양방향 조회기능추가(List를 구현한 경우만 사용가능) 
```
