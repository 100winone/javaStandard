### ๐กDay20 java.langํจํค์ง์ ์ ์ฉํ ํด๋์ค - ์ ์ฉํ ํด๋์ค
> ์ด ๊ธ์ ๋จ๊ถ์ฑ๋์ ์๋ฐ์ ์ ์ 3/e๋ฅผ ๊ธฐ๋ฐ์ผ๋ก ๊ณต๋ถํ ๋ด์ฉ์ ์ ๋ฆฌํ ๊ธ์๋๋ค.
>
> **์์ค์ ๋ฆฌ**: https://github.com/100winone/javaStandard

#### java.util.Randomํด๋์ค

```java
double randNum = Math.random();
double randNum = new Random().nextDouble(); // ์์ ๋์ผ

// 1 ~ 6 ์ฌ์ด์ ์ ์๋ฅผ ๋์๋ก ์ป๊ณ ์ถ์ ๋?        
int num = (int)(Math.random() * 6) + 1;
int num = new Random().nextInt(6) + 1; // ์์ ๋์ผ
```

#### ์ ๊ท์(Regular Expression) - java.util.regexํจํค์ง
```java
import java.util.regex.*;

public class RegularEx1 {
    public static void main(String[] args) {
        String[] data = {"bat", "baby", "bonus", "cA", "ca", "co", "c.",
                         "c0", "car", "combat", "count", "date", "disc"};
        Pattern p = Pattern.compile("c[a-z]*"); // c๋ก ์์ํ๋ ์๋ฌธ์ ์๋จ์ด
        for (int i = 0; i < data.length; i++) {
            Matcher m = p.matcher(data[i]);
            if (m.matches()) {
                System.out.print(data[i] + ",");
            }
        }
    }
}

/*
 * Pattern์ ์ ๊ท์์ ์ ์ํ๋ ๋ฐ ์ฌ์ฉ
 * Matcher๋ ์ ๊ท์(ํจํด)์ ๋ฐ์ดํฐ์ ๋น๊ตํ๋ ์ญํ ์ ํจ
 * */
```

```
1. ์ ๊ท์์ ๋งค๊ฐ๋ณ์๋ก Patternํด๋์ค์ static๋ฉ์๋์ธ Pattern compile(String regex)์
   ํธ์ถํ์ฌ Pattern์ธ์คํด์ค๋ฅผ ์ป๋๋ค.
    Pattern p = Pattern.compile("c[a-z]*");

2. ์ ๊ท์์ผ๋ก ๋น๊ตํ  ๋์์ ๋งค๊ฐ๋ณ์๋ก Patternํด๋์ค์ Matcher matcher (CharSequence 
   input)๋ฅผ ํธ์ถํด์ Matcher์ธ์คํด์ค๋ฅผ ์ป๋๋ค.
    Matcher m = p.matcher(data[i]);

3. Matcher์ธ์คํด์ค์ boolean mathces()๋ฅผ ํธ์ถํด์ ์ ๊ท์์ ๋ถํฉํ๋์ง ํ์ธํ๋ค.
    if(m.matches())
```