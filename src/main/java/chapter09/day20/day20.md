### 💡Day19 java.lang패키지와 유용한 클래스 - 유용한 클래스
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