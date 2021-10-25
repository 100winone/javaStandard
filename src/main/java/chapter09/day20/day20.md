### 💡Day20 java.lang패키지와 유용한 클래스 - 유용한 클래스
> 이 글은 남궁성님의 자바의 정석 3/e를 기반으로 공부한 내용을 정리한 글입니다.
>
> **소스정리**: https://github.com/100winone/javaStandard

#### java.util.Random클래스

```java
double randNum = Math.random();
double randNum = new Random().nextDouble(); // 위와 동일

// 1 ~ 6 사이의 정수를 난수로 얻고싶을 땐?        
int num = (int)(Math.random() * 6) + 1;
int num = new Random().nextInt(6) + 1; // 위와 동일
```

#### 정규식(Regular Expression) - java.util.regex패키지
```java
import java.util.regex.*;

public class RegularEx1 {
    public static void main(String[] args) {
        String[] data = {"bat", "baby", "bonus", "cA", "ca", "co", "c.",
                         "c0", "car", "combat", "count", "date", "disc"};
        Pattern p = Pattern.compile("c[a-z]*"); // c로 시작하는 소문자 영단어
        for (int i = 0; i < data.length; i++) {
            Matcher m = p.matcher(data[i]);
            if (m.matches()) {
                System.out.print(data[i] + ",");
            }
        }
    }
}

/*
 * Pattern은 정규식을 정의하는 데 사용
 * Matcher는 정규식(패턴)을 데이터와 비교하는 역할을 함
 * */
```

```
1. 정규식을 매개변수로 Pattern클래스의 static메서드인 Pattern compile(String regex)을
   호출하여 Pattern인스턴스를 얻는다.
    Pattern p = Pattern.compile("c[a-z]*");

2. 정규식으로 비교할 대상을 매개변수로 Pattern클래스의 Matcher matcher (CharSequence 
   input)를 호출해서 Matcher인스턴스를 얻는다.
    Matcher m = p.matcher(data[i]);

3. Matcher인스턴스에 boolean mathces()를 호출해서 정규식에 부합하는지 확인한다.
    if(m.matches())
```