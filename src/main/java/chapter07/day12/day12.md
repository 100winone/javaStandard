### 💡Day12 객체지향 프로그래밍 2 - package와 import
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/100winone/javaStandard

#### package와 import
```
- 하나의 소스파일에는 첫 번째 문장으로 단 한번의 패키지 선언만을 허용한다.
- 모든 클래스는 반드시 하나의 패키지에 속해야 한다.
- 패키지는 점(.)을 구분자로 하여 계층구조로 구성할 수 있다.
- 패키지는 물리적으로 클래스 파일(.class)을 포함하는 하나의 디렉토리이다.
```

### Package
```java
package chapter07.day12.day12;

public class PackageTest {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
/*
* 위 예제 작성 후 '-d' 옵션을 주어 shell에서 실행하게되면?
* C:\jdk1.8/work>javac -d . PackageTest.java
* 
* '-d' : 소스파일에 지정된 경로를 통해 패키지 위치 찾아 클래스파일 생성
* if) 지정된 패키지와 일치하는 디렉토리가 존재하지 않는다면? 자동으로 생성
* '-d'옵션 뒤에는 해당 패키지의 루트(root)디렉토리의 경로를 적어줌  (.)은 현재 디렉토리
* 루트 디렉토리를 클래스패스에 포함시켜야만 실행 시 JVM이 PackageTest클래스를 찾을 수 있음
* */

```

### import
> 다른 패키지의 클래스를 사용하려면 코드를 작성하기 전에 import문으로 사용하고자 하는 클래스의 패키지를 미리 명시

```
일반적인 소스파일(*.java)의 구성은 다음의 순서로 이루어짐
    1. package문
    2. import문
    3. 클래스 선언

ex) 
import 패키지명.클래스명
or
import 패키지명.*
```

> 묵시적으로 import java.lang.*; 이 선언되어 있어 System과 String 클래스 사용 가능

#### static import문
- static import문을 사용하면 static멤버를 호출할 때 클래스 이름을 생략할 수 있음

```java
import static java.lang.Integer.*; // integer 클래스의 모든 static 메서드
import static java.lang.Math.random; // Math.random()만. 괄호 안붙임
import static java.lang.System.out; // System.out을 out만으로 참조 가능

ex)
System.out.println(Math.random()); <-> out.println(random()); 
```