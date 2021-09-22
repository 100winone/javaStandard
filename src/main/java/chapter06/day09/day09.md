### 💡Day09 객체지향 프로그래밍 1 - 변수의 초기화
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/100winone/javaStandard

#### 변수의 초기화

```
멤버변수(클래스변수와 인스턴스변수)와 배열의 초기화는 선택적이지만,
지역변수의 초기화는 필수적이다.
```

```java
class InitTest{
    int x;     // 인스턴스변수
    int y = x; // 인스턴스변수
    
    void method1(){
        int i;
        int j = i; // 에러. 지역변수를 초기화하지 않고 사용
    }
}
```

```
> 멤버변수의 초기화 방법
1. 명시적 초기화(explicit initialization)
2. 생성자(constructor)
3. 초기화 블럭(initialization block)
```

#### 초기화블럭 예제
```java
public class BlockTest {
    static {
        System.out.println("static {}"); // 클래스 초기화 블럭
    }
    {
        System.out.println("{}"); // 인스턴스 초기화 블럭
    }
    public BlockTest(){
        System.out.println("생성자");
    }
    public static void main(String[] args) {
        System.out.println("BlockTest bt = new BlockTest(); ");
        BlockTest bt = new BlockTest();

        System.out.println("BlockTest bt2 = new BlockTest(); ");
        BlockTest bt2 = new BlockTest();
    }
}
```
#### 실행결과
```
static {}
BlockTest bt = new BlockTest();
{}
생성자
BlockTest bt2 = new BlockTest();
{}
생성자

/* 설명 */ 
> BlockTest가 메모리에 로딩될 때, 초기화 블럭이 가장 먼저 수행되어 'static {}'이 화면 출력
> main메서드가 수행되어 BlockTest 인스턴스가 생성되며 인스턴스 초기화 블럭 먼저 수행
> 생성자 수행 
```

#### 멤버변수의 초기화 시기와 순서
```
클래스변수의 초기화시점 : 클래스가 처음 로딩될 때 단 한번 초기화 된다.
인스턴스변수의 초기화시점 : 인스턴스가 생성될 때마다 각 인스턴스별로 초기화가 이루어진다.

클래스변수의 초기화순서 : 기본값 -> 명시적초기화 -> 클래스 초기화 블럭
인스턴스변수의 초기화순서 : 기본값 -> 명시적초기화 -> 인스턴스 초기화 블럭 -> 생성자
```

```java
class InitTest{
    /* 명시적 초기화 */
    static int cv = 1;
    int iv = 1;
    
    /* 클래스 초기화블럭 */
    static {
        cv = 2;
    }
    
    /* 인스턴스 초기화 블럭 */
    {
        iv = 2;
    }
    
    /* 생성자 */
    InitTest(){
        iv = 3;
    }
}
```
