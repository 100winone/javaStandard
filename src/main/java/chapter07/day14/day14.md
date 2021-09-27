### 💡Day14 객체지향 프로그래밍 2 - 다형성(polymorphism)
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/100winone/javaStandard

### 다형성(polymorphism)
> 한 타입의 참조변수로 여러 타입의 객체를 참조할 수 있도록 함, 조상클래스 타입의 참조변수로 자손클래스의 인스턴스를 참조할 수 있도록 함 

```java
class Tv{
    boolean power; 
    int channel;
    
    void power(){power = !power;}
    void channelUp() {++channel;}
    void channelDown() {--channel;}
}
class CaptionTv extends Tv{
    String text;
    void caption() {}
}

/*
 * 조상 클래스의 타입의 참조변수로 자손 클래스의 인스턴스를 참조하도록 하는 것이 가능
 * ex)
 * Tv t = new CaptionTv(); // 조상 타입의 참조변수로 자손 인스턴스를 참조
 * */
```

```java
CaptionTv c = new CaptionTv();
Tv t = new CaptionTv();
```
- 위 두 선언의 차이는?
  - Tv t로 선언한 참조변수는 실제로는 CaptionTv()의 인스턴스 중 Tv클래스의 멤버들만 사용할 수 있음

- CaptionTv c = new Tv(); 는 불가능하다.(컴파일 에러 발생)
    - 실제 인스턴스인 Tv의 멤버 개수보다 참조변수 c가 사용할 수 있는 멤버변수가 더 많기 때문
    - 참조변수가 사용할 수 있는 멤버의 개수는 인스턴스의 멤버 개수보다 같거나 적어야 한다.

> 조상타입의 참조변수로 자손타입의 인스턴스를 참조할 수 있지만, 반대로 자손타입의 참조변수로 조상타입의 인스턴스를 참조할 수는 없다.

#### 참조변수의 형변환
> 조상타입의 참조변수를 자손타입의 참조변수로의 형변환만 가능

```
자손타입 -> 조상타입 (Up-casting) : 형변환 생략가능
자손타입 <- 조상타입 (Down-casting) : 형변환 생략불가
```

> 서로 상속관계에 있는 클래스 타입의 참조변수간의 형변환은 양방향으로 자유롭게 수행될 수 있으나, 참조변수가 참조하고 있는 인스턴스의 자손타입으로 형변환을 하는 것은 허용되지 않는다. 참조변수가 가리키는 인스턴스의 타입이 무엇인지 확인하는 것이 중요하다.

#### instanceof연산자

ex) c instanceof FireEngine -> true or false 리턴

> 조상타입의 참조변수로 자손타입의 인스턴스를 참조할 수 있기 때문에, 참조변수의 타입과 인스턴스의 타입이 항상 일치하지는 않는다. 조상타입의 참조변수로는 실제 인스턴스의 멤버들을 모두 사용할 수 없기 때문에, 실제 인스턴스와 같은 타입의 참조변수로 형변환을 해야만 인스턴스의 모든 멤버들을 사용할 수 있다.

- 실제 인스턴스와 같은 타입의 instanceof연산 이외에 조상타입의 instanceof연산에도 true를 결과로 얻으며, instanceof연산의 결과가 true라는 것은 검사한 타입으로의 형변환을 해도 아무런 문제가 없다는 뜻이다.

#### 참조변수와 인스턴스의 연결
> 멤버변수가 조상 클래스와 자손 클래스에 중복으로 정의된 경우, 조상 타입의 참조변수를 사용했을 때는 조상 클래스의 선언된 멤버변수가 사용되고, 자손타입의 참조변수를 사용했을 때는 자손 클래스에 선언된 멤버변수가 사용된다.
```java
package chapter07.day14;

public class BindingTest {
    public static void main(String[] args) {
        Parent p = new Child();
        Child c = new Child();

        System.out.println("p.x = " + p.x);
        p.method();
        System.out.println("c.x = " + c.x);
        c.method();
    }
}

class Parent{
    int x = 100;

    void method(){
        System.out.println("Parent Method");
    }
}

class Child extends Parent {
    int x = 200;

    void method(){
        System.out.println("Child Method");
    }
}
```
```
위 예제의 경우 참조변수 p와 c 모두 Child인스턴스를 참조하고 있다. 
Parent클래스와 Child클래스는 서로 같은 멤버들을 정의하고 있다.
메서드인 method()의 경우 참조변수의 타입에 관계없이 항상 실제 인스턴스의 타입인 child클래스에 정의된 메서드 호출
But, 인스턴스변수인 x는 참조변수의 타입에 따라서 달라짐 
```

#### 여러 종류의 객체를 배열로 다루기
> 조상타입의 참조변수로 자손타입의 객체를 참조하는 것이 가능하므로, Product클래스가 Tv, Computer, Audio클래스의 조상일 때, 다음과 같이 할 수 있다.
```java
Product p1 = new Tv();
Product p2 = new Computer();
Product p3 = new Audio();

Product p[] = new Product[3];
p[0] = new Tv();
p[1] = new Computer();
p[2] = new Audio();
```

```java
Product2[] item = new Product2[10];
// 배열의 크기를 10으로 했기 때문에 11개 이상의 제품을 구입할 수 없는 것이 문제
// 이런 경우 Vector 클래스 사용
```
