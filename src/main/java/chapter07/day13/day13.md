### 💡Day13 객체지향 프로그래밍 2 - 제어자(modifier)
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/100winone/javaStandard

### 제어자(modifier)
> 클래스, 변수 또는 메서드의 선언부에 함께 사용되어 부가적인 의미를 부여

```
접근 제어자 - public, protected, default, private
그 외 - static, final, abstract, native, transient, synchronized, volatile, strictfp
```

#### static -  클래스의, 공통적인
- static이 사용될 수 있는 곳 - 멤버변수, 메서드, 초기화 블럭
> 클래스변수(static멤버변수)는 인스턴스에 관계없이 같은 값을 갖는다.

- static 멤버변수
    - 모든 인스턴스에 공통적으로 사용되는 클래스변수가 된다.
    - 클래스변수는 인스턴스를 생성하지 않고도 사용 가능하다.
    - 클래스가 메모리에 로드될 때 생성된다.
- static 메서드
  - 인스턴스를 생성하지 않고도 호출이 가능한 static 메서드가 된다.
  - static메서드 내에서는 인스턴스 멤버들을 직접 사용할 수 없다.

```java
class StaticTest{
    static int width = 200;
    static int height = 120;
    
    static { // 클래스 초기화 블럭
        
    }

    static int max(int a, int b) {
        return a > b ? a : b; // 클래스 메서드(static 메서드)
    }
}
```

#### final - 마지막의, 변경될 수 없는
- final이 사용될 수 있는 곳 - 클래스, 메서드, 멤버변수, 지역변수
> '마지막의' 또는 '변경될 수 없는'의 의미를 가지고 있음

- final 클래스 
  - 변경될 수 없는 클래스, 확장될수 없는 클래스가 된다.
  - final로 지정된 클래스는 다른 클래스의 조상이될 수 없다.
- final 메서드
  - 변경될 수 없는 메서드, final로 지정된 메서드는 오버라이딩을 통해 재정의 될 수 없다.
- final 멤버변수, 지역변수 
  - 변수 앞에 final이 붙으면, 값을 변경할 수 없는 상수가 된다.

```java
final class FinalTest{            // 조상이 될 수 없는 클래스 
    final int MAX_SIZE = 10;      // 값을 변경할 수 없는 멤버변수 (상수)
    
    final void getMaxSize(){      // 오버라이딩할 수 없는 메서드(변경불가)
        final int LV = MAX_SIZE;  // 값을 변경할 수 없는 지역변수(상수)
        return MAX_SIZE;
    }
}
```

####abstract - 추상의, 미완성의
- abstract가 사용될 수 있는곳 - 클래스, 메서드
> 메서드의 선언부만 작성하고 실제 수행내용은 구현하지 않은 추상 메서드를 선언하는데 사용

- abstract 클래스
  - 클래스 내에 추상 메서드가 선언되어 있음을 의미
- abstract 메서드
  - 선언부만 작성하고 구현부는 작성하지 않는 추상 메서드임을 알림

#### 접근 제어자(access moidifier)
- 접근 제어자가 사용될 수 있는 곳 - 클래스, 멤버변수, 메서드, 생성자
> 해당하는 멤버 또는 클래스를 외부에서 접근하지 못하도록 제한하는 역할

```
private - 같은 클래스 내에서만 접근이 가능
default - 같은 패키지 내에서만 접근이 가능
protected - 같은 패키지내에서, 그리고 다른 패키지의 자손클래스에서 접근이 가능 
public - 접근 제한이 전혀 없음
```

- 접근 제어자를 사용하는 이유
  - 외부로부터 데이터를 보호하기 위해서
  - 외부에는 불필요한, 내부적으로 사용되는, 부분을 감추기 위해서
  
#### 생성자의 접근 제어자
```java
class Singleton{
    private static Singleton s = new Singleton();
    // getInstance()에서 사용될 수 있도록 인스턴스가 미리 생성되어야 하므로 static 이여야함
    private Singleton(){
        //...   
    }

    //...
    public static Singleton getInstance() {
        if (s == null) {
            s = new Singleton();
        }
        return s;
    }
}
```
- 생성자의 접근 제어자를 private으로 지정하면, 외부에서 생성자에 접근할 수 없으므로 인스턴스를 생성할 수 없게 되지만 클래스 내부에서는 인스턴스의 생성이 가능
- 대신 인스턴스를 생성해서 반환해주는 public메서드를 제공함으로써 외부에서 이 클래스의 인스턴스를 사용하도록 할 수 있음
- 이 메서드는 public인 동시에 static이어야 한다.

대상|사용가능한 제어자|
|------|-------|
|클래스|public, (default), final, abstract|
|메서드|모든 접근 제어자, final, abstract, static|
|멤버변수|모든 접근 제어자, final, static|
|지역변수|final|

```
1. 메서드에 static과 abstract를 함께 사용할 수 없다.
    - static메서드는 몸통이 있는 메서드에만 사용할 수 있기 때문이다.
2. 클래스에 abstract와 final을 동시에 사용할 수 없다.
    - 클래스에 사용되는 final은 클래스를 확장할 수 없다는 의미이고 
      abstract는 상속을 통해서 완성되어야 한다는 의미이므로 서로 모순되기 때문이다.
3. abstract메서드의 접근제어자가 private일 수 없다. 
    - abstract메서드는 자손클래스에서 구현해주어야 하는데 접근 제어자가 private이면
      자손클래스에서 접근할 수 없기 때문이다.
4. 메서드에 private와 final을 같이 사용할 필요는 없다.
    - 접근 제어자가 private인 메서드는 오버라이딩 될 수 없기 때문이다
      이 둘 중 하나만 사용해도 의미가 충분하다.
```