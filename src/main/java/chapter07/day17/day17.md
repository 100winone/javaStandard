### 💡Day17 객체지향 프로그래밍 2 - 내부 클래스(inner class)
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/100winone/javaStandard

### 내부 클래스(inner class)
> 클래스 내에 선언된 클래스

```
내부 클래스의 장점
    - 내부 클래스에서 외부 클래스의 멤버들을 쉽게 접근할 수 있다.
    - 코드의 복잡성을 줄일 수 있다(캡슐화).
```

|내부클래스|특 징|
|-------|-------|
|인스턴스 클래스|외부 클래스의 멤버변수 선언위치 선언, 외부클래스의 인스턴스 멤버처럼 다루어짐. 외부 클래스의 인스턴스멤버들과 관련된 작업에 사용될 목적으로 선언|
|스태틱 클래스|외부 클래스의 멤버변수 선언위치 선언, 외부클래스 static멤버처럼 다루어짐. 외부 클래스의 static멤버, 특히 static메서드에 사용될 목적으로 선언|
|지역 클래스|외부 클래스의 메서드나 초기화블럭 안에 선언, 선언된 영역 내부에서만 사용|
|익명 클래스|클래스의 선언과 객체의 생성을 동시에 하는 이름없는 클래스(일회용)|