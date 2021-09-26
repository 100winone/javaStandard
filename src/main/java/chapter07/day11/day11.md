### 💡Day11 객체지향 프로그래밍 2 - 오버라이딩(overriding)
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/100winone/javaStandard

#### 오버라이딩(overriding)
> 조상 클래스로부터 상속받은 메서드의 내용을 변경하는 것

```java
class Point {
    int x;
    int y;
    
    String getLocation() {
        return "x :" + x + ", y :" + y;
    }
}

class Point3D extends Point {
    int z;

    String getLocation() { // 오버라이딩
        return "x :" + x + ", y :" + y + ", z :" + z;
    }
}
```

#### 오버라이딩의 조건
```
자손 클래스에서 오버라이딩하는 메서드는 조상 클래스의 메서드와
    - 이름이 같아야 한다.
    - 매개변수가 같아야 한다.
    - 반환타입이 같아야 한다.
    
1. 접근 제어자는 조상 클래스의 메서드보다 좁은 범위로 변경 할 수 없다.
    ex) 조상 클래스에 정의된 메서드의 접근 제어자가 protected라면, 
        이를 오버라이딩하는 자손클래스의 메서드는 protected 또는 public 이여야함
2. 조상 클래스의 메서드보다 많은 수의 예외를 선언할 수 없다.
3. 인스턴스 메서드를 static메서드 또는 그 반대로 변경할 수 없다.
```

#### 오버로딩 vs 오버라이딩
```java
/*
 오버로딩(overloading) 기존에 없는 새로운 메서드를 정의하는 것(new)
 오버라이딩(overriding) 상속받은 메서드의 내용을 변경하는 것(change, modify)
 */
class Parent{
    void parentMethod(){}
}
class Child extends Parent{
    void parentMethod(){} // 오버라이딩
    void parentMethod(int i){} // 오버로딩
}
```

#### super
> 자손 클래스에서 조상 클래스로부터 상속받은 멤버를 참조하는데 사용되는 참조변수
- 인스턴스 메서드에서만 사용가능(static메서드에서는 x)

```java
class Point {
    int x;
    int y;
    
    String getLocation() {
        return "x :" + x + ", y :" + y;
    }
}

class Point3D extends Point {
    int z;

    String getLocation() { // 오버라이딩
//        return "x :" + x + ", y :" + y + ", z :" + z;
        return super.getLocation() + ", z :" + z; // 조상 메서드 호출
    }
}
```

```
Object클래스를 제외한 모든 클래스의 생성자 첫 줄에는 생성자,this() 또는 super(),를 호출해야 한다. 
그렇지 않으면 컴파일러가 자동적으로 'super();'를 생성자의 첫 줄에 삽입한다.

1. 클래스 - 어떤 클래스의 인스턴스를 생성할 것인가?
2. 생성자 - 선택한 클래스의 어떤 생성자를 이용해서 인스턴스를 생성할 것인가?
```

```java
class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    String getLocation() {
        return "x :" + x + ", y :" + y;
    }
}

class Point3D extends Point {
    int z;
    
    Point3D(int x, int y, int z) {
        /* 생성자가 따로 호출되어있지 않기 때문에 조상클래스의 생성자인 super(); 가 생략되어 있음
         * But, Point() 클래스의 기본 생성자가 선언되어있지 않기 때문에 에러가 발생됨
         * super(x, y); 가 호출되도록 변경하면 에러 x
         * */
        this.x = x;
        this.y = y;
        this.z = z;
    }
    String getLocation() { // 오버라이딩
//        return "x :" + x + ", y :" + y + ", z :" + z;
        return super.getLocation() + ", z :" + z; // 조상 메서드 호출
    }
}
```
> 조상 클래스의 멤버변수는 이처럼 조상의 생성자에 의해 초기화되도록 해야함
