### 💡Day07 객체지향 프로그래밍 1 - 오버로딩(overloading)
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
> 
> **소스정리**: https://github.com/100winone/javaStandard

#### 오버로딩(overloading)
> 클래스 내에 같은 이름의 메서드를 여러 개 정의하는 것

```
오버로딩의 성립조건
1. 메서드 이름이 같아야 한다.
2. 매개변수의 개수 또는 타입이 달라야 한다.
```


```java
// [보기1] 오버로딩 X
int add(int a, int b) {return a + b}
int add(int x, int y) {return x + y}

// [보기2] 오버로딩 X -> 리턴타입은 구분하지 않음
int add(int a, int b) {return a + b}
long add(int a, int b) {return a + b}

// [보기3] 오버로딩 O
long add(int a, long b) {return a + b}
long add(long a, int b) {return a + b}
```

#### 오버로딩의 장점
- 여러 메서드들이 하나의 이름으로 정의될 수 있음
- 메서드의 이름을 절약하고, 이름을 보고 같은 기능을 예측 가능하게 함
