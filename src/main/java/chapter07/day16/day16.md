### 💡Day16 객체지향 프로그래밍 2 - 인터페이스(interface)
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/100winone/javaStandard

### 인터페이스(interface)
> 오직 추상메서드와 상수만을 멤버로 가질 수 있으며, 그 외의 다른 어떠한 요소도 허용하지 않음

```
추상클래스 vs 인터페이스 차이

추상클래스
    - 부분적으로 완성된 '미완성 설계도'
    - 일반 메서드 또는 멤버 변수를 가질 수 있음
인터페이스
    - 구현된 것은 아무 것도 없고 밑그림만 그려진 '기본 설계도'
    - 일반 메서드 또는 멤버변수를 구성원으로 가질 수 없음
```

```java
inferface 인터페이스이름 {
    public static final 타입 상수이름 = 값;
    public abstract 메서드이름(매개변수목록);
}
```

#### 인터페이스 멤버 제약사항
- 모든 멤버변수는 public static final 이어야 하며, 이를 생략할 수 있다.
- 모든 메서드는 public abstract 이어야 하며, 이를 생략할 수 있다.
- 두 제어자는 편의상 생략 가능하다.

```java
inferface PlayingCard {
    public static final int SPADE = 4;
    public int DIAMOND = 3;
    static int HEART = 2;
    int CLOVER = 1;
    
    public abstract String getCardNumber();
    String getCardKind();
}
```

#### 인터페이스의 상속
> 인터페이스는 인터페이스로부터만 상속받을 수 있으며, 클래스와는 달리 다중상속, 즉 여러 개의 인터페이스로부터 상속을 받는 것이 가능
```java
interface Movable{
    void move(int x, int y);
}
interface Attackable{
    void attack(Unit u);
}

interface Fightable extends Movable, Attackable{}
```

#### 인터페이스의 구현
```java
class 클래스이름 implements 인터페이스이름{
    // 인터페이스에 정의된 추상메서드 구현
}
class Fighter implements Fightable {
    public void move(int x, int y){}
    public void attack(Unit u){}
}

/* 만일 구현하는 인터페이스의 메서드 중 일부만 구현한다면, abstract를 붙여서 추상클래스로 선언해야함*/

abstract class Fighter implements Fightable {
    public void move(int x, int y){}
}

class Fighter extends Unit implements Fightable{
    /* 이처럼 상속과 구현 동시에 가능*/
}
```

