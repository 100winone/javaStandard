### 💡Day10 객체지향 프로그래밍 2 - 상속(inheritance)
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/100winone/javaStandard

#### 상속(inheritance)
> 기존의 클래스를 재사용하여 새로운 클래스를 작성하는 것

```
조상 클래스 - 부모(parent)클래스, 상위(super)클래스, 기반(base)클래스
자손 클래스 - 자식(child)클래스, 하위(sub)클래스, 파생된(derived)클래스
```

```java
class Parent()
class Child extends Parent()
```

#### 상속특징
- 생성자와 초기화 블럭은 상속되지 않는다. 멤버만 상속된다.
- 자손 클래스의 멤버 개수는 조상 클래스보다 항상 같거나 많다.

> 자손 클래스의 인스턴스를 생성하면 조상 클래스의 멤버와 자손 클래스의 멤버가 합쳐진 하나의 인스턴스로 생성된다.

### 클래스간의 관계 - 포함관계
> 한 클래스의 멤버변수로 다른 클래스 타입의 참조변수를 선언하는 것

```java
class Circle(){
    int x;
    int y;
    int r;
}
class Point {
    int x;
    int y;
}

// 아래처럼 변경
class Circle{
    Point c = new Point(); 
    int r;
}
```

#### 클래스간의 관계 결정하기
- '~은 ~이다(is-a)'~은 ~을 가지고 있다(has-a)'를 넣어서 문장 만들어보기

```
상속관계 - '~은 ~이다.(is-a)'
포함관계 - '~은 ~을 가지고 있다.(has-a)'
```

```java
Circle c = new Circle(new Point(150, 150), 50);
-> 아래와 같이 변경

Point p = new Point(150, 150);
Circle c = new Circle(p, 50);
```

#### 단일상속(single inheritance)
> 자바에서는 하나 이상의 클래스로부터 상속을 받을 수 없다.

```java
/* 아래와같아 하나는 상속받고, 하나는 클래스를 호출하여 사용 */
class Tv{
    boolean power;
    int channel;

    void power(){
        power = !power;
    }
    void channelUp(){
        ++channel;
    }
    void channelDown(){
        --channel;
    }
}
class VCR {
    boolean power;
    int counter = 0;
    void power(){
        power = !power;
    }
    void play(){
        /* 내용생략 */
    }

}
public class TVCR extends Tv{
    VCR vcr = new VCR(); // Tv 클래스를 조상으로 하고, VCR클래스는 TVCR 클래스에 포함신키는 방식으로 사용
    int counter = vcr.counter;
    void play(){
        vcr.play();
    }
}

```

#### Object클래스 - 모든 클래스의 조상
> Object클래스는 모든 클래스 상속계층도의 최상위에 있는 조상클래스

```java
class Tv extends Object{ // 이런식으로 자동적으로 Object가 상속됨
    // ...
}
```