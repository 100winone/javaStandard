### 💡Day05 객체지향 프로그래밍 1 - 클래스와 객체
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/100winone/javaStandard

####클래스와 객체

클래스의 정의 - 객체를 정의해 놓은 것

클래스의 용도 - 객체를 생성하는데 사용

유형의 객체 - 책상, 의자, 자동차, TV와 같은 사물

무형의 객체 - 수학공식, 프로그램 에러와 같은 논리나 개념

인스턴스화 - 클래스로부터 객체를 만드는 과정

인스턴스 - 어떤 클래스로부터 만들어진 객체

### 객체

- 객체는 속성과 기능 두 종류의 구성요소 이루어짐
- 클래스는 객체를 정의한 것이므로, 클래스에는 객체의 모든 속성과 기능이 정의

속성(property) → 멤버변수(variable)

기능(function) → 메서드(method)

### 인스턴스의 생성과 사용

```java
//ex)
//클래스명 변수명;
//변수명 = new 클래스명();

Tv t; 
t = new Tv();
```

> 인스턴스는 참조변수를 통해서만 다룰 수 있으며, 참조변수의 타입은 인스턴스의 타입과 일치해야한다


```java
public class TvTest3 {
    public static void main(String[] args) {
        Tv t1 = new Tv();
        Tv t2 = new Tv();
        System.out.println("t1의 channel값은 " + t1.channel + "입니다.");
        System.out.println("t2의 channel값은 " + t2.channel + "입니다.");
        t2 = t1; // t1의 저장된 주소값을 넘기는 것
        t1.channel = 7; // 따라서 t1.channel의 값을 변경하였지만 
                        // t2.channel도 t1과 같은 주소를 가리키기 때문에 같이 변경
        System.out.println("t1의 channel값을 7로 변경하였습니다.");

        System.out.println("t1의 channel값은 " + t1.channel + "입니다.");
        System.out.println("t2의 channel값은 " + t2.channel + "입니다.");
    }
```

> 둘 이상의 참조변수가 하나의 인스턴스를 가리키는(참조하는) 것은 가능하지만 하나의 참조변수로 여러개의 인스턴스를 가리키는 것은 가능하지 않다

### 객체 배열

- 객체 배열 안에 객체가 저장되는 것이 아닌 객체의 주소가 저장
- 즉, 참조변수들을 하나로 묶은 참조변수 배열

```java
    Tv[] tvArr = new Tv[3];

    for (int i = 0; i < tvArr.length; i++) {
        tvArr[i] = new Tv();
        tvArr[i].channel = i + 10;
    }
    for (int i = 0; i < tvArr.length; i++){
        tvArr[i].channelUp();
        System.out.printf("tvArr[%d].channelUp=%d%n",i,tvArr[i].channel);
    }
```

###클래스의 또 다른 정의

```
변수 - 하나의 데이터를 저장할 수 있는 공간
배열 - 같은 종류의 여러 데이터를 하나의 집합으로 저장할 수 있는 공간
구조체 - 서로 관련된 여러 데이터를 종류에 관계없이 하나의 집합으로 저장할 수 있는 공간
클래스 - 데이터와 함수의 결합 (구조체 + 함수)
```



