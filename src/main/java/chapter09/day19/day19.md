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

