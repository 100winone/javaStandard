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

```
오버라이딩 할 때는 조상의 메서드보다 넓은 범위의 접근 제어자를 지정해야 하기 때문에,
'public abstract'가 생략된 인터페이스 메서드를 구현할 때에는 접근 제어자를 반드시 public으로
해주어야 한다.
```

```java

public class Tv {   
    protected boolean power;
    protected boolean channel;
    protected boolean volume;
    
    public void power() { power = !power;}
    public void channelUp() { channel++;}
    public void channelDown() { channel--;}
    public void volumeUp() { volume++;}
    public void volumeDown() { volume--;}
}
public class VCR {
    protected int counter;
        
    public void play() {
        // tape를 재생한다.
    }
    public void stop() {
        // 재생을 멈춘다.
    }
    public void reset() {
        counter = 0;
    }
    public int getCounter() {
        return counter;
    }
    public void setCounter(int c) {
        counter = c;
    }
}

class PolyArgumentTest {
    public static void main(String[] args) {
        Buyer b = new Buyer();

        b.buy(new Tv());
        b.buy(new Computer());

        System.out.println("현재 남은 돈은 " + b.money + "만원입니다.");
        System.out.println("현재 보너스점수는 " + b.bonusPoint + "점입니다.");
    }
}

```

```java
// VCR클래스에 정의된 메서드와 일치하는 추상메서드를 갖는 인터페이스를 작성
public interface IVCR {
    public void play();
    public void stop();
    public void reset();
    public int getCounter();
    public void setCounter(int c);
}
```

```java
// IVCR 인터페이스를 구현하고 Tv클래스로부터 상속받는 TVCR클래스를 작성
// VCR클래스 타입의 참조변수를 멤버변수로 선언하여 IVCR인터페이스의 추상 메서드를 구현하는데 사용
public class TVCR extends Tv implements IVCR {
    VCR vcr = new VCR();
    public void play() {
        vcr.play();
    }
    public void stop() {
        vcr.stop();
    }
    public void reset() {
        vcr.reset();
    }
    public int getCounter() {
        vcr.getCounter();
    }
    public void setCounter(int c) {
        return vcr.setCounter(c);
    }
}
```
- VCR클래스의 인스턴스를 사용하면 손쉽게 다중상속을 구현할 수 있음
- VCR클래스의 내용이 변경되어도 변경된 내용이 TVCR클래스에도 자동적으로 반영

#### 인터페이스를 이용한 다형성
> 해당 인터페이스 타입의 참조변수로 이를 구현한 클래스의 인스턴스를 참조할 수 있고, 인터페이스 타입으로의 형변환도 가능

```java
/* 인터페이스 Fightable을 클래스 Fighter가 구현했을 때, 
 * Fighter인스턴스를 Fightable타입의 참조변수로 참조하는 것이 가능 */
Fightable f = (Fightable)new Fighter();
or
Fightable f = new Fighter();
```


```
인터페이스는 메서드의 매개변수의 타입으로 사용될 수 있다.
void attack(Fightable f){
    ///
}
- 메서드 호출 시 해당 인터페이스를 구현한 클래스의 인스턴스를 매개변수로 제공해야 함
- attack 메서드를 호출할 때는 매개변수로 Fightable인터페이스를 구현한 클래스의 인스턴스를 넘겨주어야 함    
```