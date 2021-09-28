### 💡Day15 객체지향 프로그래밍 2 - 추상클래스(abstract class)
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/100winone/javaStandard

### 추상클래스(abstract class)
> 인스턴스는 생성할 수 없는 상속을 통해서 자손클래스에 의해서만 완성될 수 있는 클래스 (미완성 설계도)

#### 추상메서드(abstract method)
> 선언부만 작성하고 구현부는 작성하지 않은 채로 남겨 둔 것

```java
/* 주석을 통해 어떤 기능을 수행할 목적으로 작성하였는지 설명한다. */
abstract 리턴타입 메서드 이름();
```

- 추상클래스로부터 상속받는 자손클래스는 오버라이딩을 통해 조상인 추상클래스의 추상메서드를 모두 구현해주어야 함
- 조상으로부터 상속받은 추상메서드 중 하나라도 구현하지 않는다면, 자손클래스 역시 추상클래스로 지정

```java
abstract class Player{              // 추상클래스
    abstract void play(int pos);    // 추상메서드
    abstract void stop();           // 추상메서드
}
class AudioPlayer extends Player{
    void play(int pos){ /* 내용 생략 */} // 추상메서드 구현
    void stop(){/* 내용 생략 */}         // 추상메서드 구현
}
class AbstractPlayer extends Player{
    void play(int pos){ /* 내용 생략 */} // 추상메서드 구현
}
```

#### 추상클래스의 작성
```
추상화 - 클래스간의 공통점을 찾아내서 공통의 조상을 만드는 작업
구체화 - 상속을 통해 클래스를 구현, 확장하는 작업
```

