### 💡Day08 객체지향 프로그래밍 1 - 생성자(Constructor)
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/100winone/javaStandard

#### 생성자(Constructor)
> 인스턴스가 생성될 때 호출되는 '인스턴스 초기화 메서드'

```
생성자의 조건
1. 생성자의 이름은 클래스의 이름과 같아야 한다.
2. 생성자는 리턴 값이 없다.
```

```java
class Card{
    Card(){ 
        // 매개변수가 없는 생성자
    }
    Card(String k, int num){
        // 매개변수가 있는 생성자
    }
}
```

```java
Card c = new Card();

1. 연산자 new에 의해서 메모리(heap)에 Card클래스의 인스턴스가 생성된다.
2. 생성자 Card()가 호출되어 수행된다.
3. 연산자 new의 결과로, 생성된 Card인스턴스의 주소가 반환되어 참조변수 c에 저장된다.
```

> 기본 생성자가 컴파일러에 의해서 추가되는 경우는 클래스에 정의된 생성자가 하나도 없을 때 뿐이다.

#### 생성자에서 다른 생성자 호출하기 - this(), this

```
- 생성자의 이름으로 클래스이름 대신 this를 사용한다.
- 한 생성자에서 다른 생성자를 호출할 때는 반드시 첫 줄에서만 호출이 가능하다.
```

```java
Car(String color) {
    door = 5;
    Car(color, "auto", 4); // 에러1. 생성자의 두 번째 줄에서 다른 생성자 호출
                           // 에러2. this(color, "auto", 4); 로 해야함
        }
        
/*
 * 생성자에서 다른 생성자는 첫 줄에서만 호출이 가능하다.
 * */
```

```java
/* this로 호출하는 생성자 예제*/

class Car2{
String color;
String gearType;
int door;

    Car2(){
        this("white", "auto", 4);
    }

    Car2(String color) {
        this(color, "auto", 4);
    }
    Car2(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
}
public class CarTest2 {
public static void main(String[] args) {
Car2 c1 = new Car2();
Car2 c2 = new Car2("blue");

        System.out.println("c1의 color=" + c1.color + ", c1.gearType=" + c1.gearType +", c1.door=" + c1.door);
        System.out.println("c2의 color=" + c2.color + ", c2.gearType=" + c2.gearType +", c2.door=" + c2.door);
    }
}
```

```
this - 인스턴스 자신을 가리키는 참조변수, 인스턴스의 주소가 저장되어 있다.
this(), this(매개변수) - 생성자, 같은 클래스의 다른 생성자를 호출할 때 사용한다.
```
> this는 '참조변수', this()는 '생성자'

```
인스턴스를 생성할 때는 다음의 2가지 사항을 결정해야한다.
    1. 클래스 - 어떤 클래스의 인스턴스를 생성할 것인가?
    2. 생성자 - 선택한 클래스의 어떤 생성자로 인스턴스를 생성할 것인가?
```