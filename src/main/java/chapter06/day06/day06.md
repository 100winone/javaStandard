### 💡Day06 객체지향 프로그래밍 1 - 변수와 메서드
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/100winone/javaStandard

#### 변수와 메서드

|변수의 종류|선언위치|생성시기|
|------|------|-------|
|클래스 변수|클래스영역|클래스가 메모리에 올라갈 때|
|인스턴스변수|클래스영역|인스턴스가 생성되었을 때|
|지역변수|클래스 영역 이외의 영역|변수 선언문이 수행되었을 때

> 인스턴스변수는 인스턴스가 생성될 때 마다 생성되므로 인스턴스마다 각기 다른 값을 유지할 수 있지만, 클래스 변수는 모든 인스턴스가 하나의 저장공간을 공유하므로, 항상 공통된 값을 갖는다

#### JVM의 메모리구조

> 주요 영역 - 1. 메서드영역 2. 힙 3. 호출스택

1. 메서드영역(method area)
    - 프로그램 실행 중 클래스가 사용되면, JVM은 해당 클래스의 클래스파일(*.class)을 읽어서 분석, 클래스에 대한 정보(클래스 데이터)를 이 영역에 저장
    - 클래스의 클래스 변수도 이 영역에 함께 생성
2. 힙(heap)
    - 인스턴스가 생성되는 공간
    - 프로그램 실행 중 생성되는 인스턴스(인스턴스 변수)는 모두 이곳에 생성
3. 호출스택(call stack 또는 executive stack)
    - 메서드의 작업에 필요한 메모리 공간 제공
    - 메모리가 작업을 수행하는 동안 지역변수(매개변수 포함)들과 연산의 중간결과 등을 저장하는데 사용
    - 메서드 작업 마치면 할당된 메모리공간 반환되어 비워짐

#### 기본형 매개변수와 참조형 매개변수

```
기본형 매개변수 - 변수의 값을 읽기만 할 수 있다.(read only)
참조형 매개변수 - 변수의 값을 읽고 변경할 수 있다.(read & write)
```

> 반환타입이 '참조형' 이라는 것은 메서드가 '객체의 주소'를 반환한다는 것을 의미한다.


#### 클래스 메서드(static메서드)와 인스턴스 메서드
```
1. 클래스를 설계할 때, 멤버변수 중 모든 인스턴스에 공통적으로 사용해야하는 것에 static을 붙인다.
2. 클래스 변수(static변수)는 인스턴스를 생성하지 않아도 사용할 수 있다.
3. 클래스 메서드(static메서드)는 인스턴스 변수를 사용할 수 없다.
4. 메서드 내에서 인스턴스 변수를 사용하지 않는다면, static을 붙이는 것을 고려한다.
```

```java
public class MemberCall {
   int iv = 10;
   static int cv = 20;

   int iv2 = cv;
   //static int cv2 = iv // error, 클래스 변수는 인스턴스변수를 사용할 수 없음
   static int cv2 = new MemberCall().iv; // 이렇게 객체 생성 해야함

   static void staticMethod1() {
      System.out.println(cv);
//        System.out.println(iv); 에러. 클래스메서드에서 인스턴스변수 사용 불가
      MemberCall c = new MemberCall(); // 이처럼 객체 생성해주어야 인스턴스 변수 사용가능
      System.out.println(c.iv);
   }

   void instanceMethod1() {
      System.out.println(cv);
      System.out.println(iv); // 인스턴스 메서드에서는 인스턴스변수 사용 가능
   }

   static void staticMethod2() {
      staticMethod1();
//        instanceMethod1(); 에러. 클래스메서드에서 인스턴스메서드 사용 불가
      MemberCall c = new MemberCall(); // 이처럼 객체 생성해주어야 인스턴스 변수 사용가능
      c.instanceMethod1();
   }

   void instanceMethod2() {
      staticMethod1();
      instanceMethod1();
   }
}
```

> 인스턴스멤버간 호출에는 아무런 문제가 없다. 하나의 인스턴스멤버가 존재한다는 것은 인스턴스가 이미 생성되어있다는 것을 의미하며, 즉 다른 인스턴스멤버들도 모두 존재하기 때문이다.