### 💡Day19 java.lang패키지와 유용한 클래스 - java.lang패키지
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/100winone/javaStandard

### java.lang패키지
> 가장 기본이 되는 클래스들을 포함하고, java.lang패키지의 클래스들은 import문 없이도 사용 가능

####hashCode
- 문자열의 내용이같으면 항상 동일한 해시코드값을 얻음 
  - 만약 str1 == str2 == "HELLO" 라면  str1.hashCode(), str2.hashCode()의 값은 같음
  - but, System.identityHashCode(str1), System.identityHashCode(str2)의 값은 다름

####toString
- 인스턴스에 대한 정보를 문자열로 제공할 목적으로 정의

####clone
- 자신을 복제하여 새로운 인스턴스를 생성

ex)
```java
class Point implements Cloneable { // Cloneable 인터페이스를 구현한 클래스에서만 clone() 호출 가능
  int x;
  int y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  public String toString(){
    return "x=" + x + ", y= " + y;
  }
  public Object clone(){
    Object obj = null;
    try{
      obj = super.clone(); // clone()은 반드시 예외처리 해주어야함
    } catch(CloneNotSupportedException e){}
    return obj;
  }
}
public class CloneEx1 {
  public static void main(String[] args) {
    Point original = new Point(3, 5);
    Point copy = (Point) original.clone();
    System.out.println(original);
    System.out.println(copy);
  }
}
```

#### String클래스

- 변경 불가능한(immutable) 클래스
- 문자열을 저장하고 이를 다루는데 필요한 메서드를 제공
- 덧셈 연산자 '+'를 사용하여 문자열을 결합하는 것은 연산 시 마다 새로운 문자열을 가진 String인스턴스가 생성되어 메모리 공간 차지


```
String s = new String("Hello");              -> s = "Hello"

char[] c = {'H', 'e', 'l', 'l', 'o '};
String s = new String(c);                    -> s = "Hello"

StringBuffer sb = new StringBuffer("Hello");
String s = new String(sb);                   -> s = "Hello"

```

#### 문자 인코딩 변환
- getBytes() 사용하면 문자열의 문자 인코딩을 다른 인코딩으로 변경 가능
```
byte[] utf8_str = "가".getBytes("UTF-8");    // 문자열을 UTF-8로 변환
String str = new String(utf8_str, "UTF-8"); // byte배열을 문자열로 변환
```

#### StringBuffer클래스와 StringBuilder클래스

- StringBuffer클래스
```
- 인스턴스를 생성할 때 문자열 변경이 가능
- 인스턴스 생성시 그 크기를 지정 가능
- equals메서드를 오버라이딩하지 않아서 equals메서드를 사용하여도 "=="를 사용하는 것과 같은 결과를 얻음
```

