### ๐กDay19 java.langํจํค์ง์ ์ ์ฉํ ํด๋์ค - java.langํจํค์ง
> ์ด ๊ธ์ ๋จ๊ถ์ฑ๋์ ์๋ฐ์ ์ ์ 3/e๋ฅผ ๊ธฐ๋ฐ์ผ๋ก ๊ณต๋ถํ ๋ด์ฉ์ ์ ๋ฆฌํ ๊ธ์๋๋ค.
>
> **์์ค์ ๋ฆฌ**: https://github.com/100winone/javaStandard

### java.langํจํค์ง
> ๊ฐ์ฅ ๊ธฐ๋ณธ์ด ๋๋ ํด๋์ค๋ค์ ํฌํจํ๊ณ , java.langํจํค์ง์ ํด๋์ค๋ค์ import๋ฌธ ์์ด๋ ์ฌ์ฉ ๊ฐ๋ฅ

#### hashCode
- ๋ฌธ์์ด์ ๋ด์ฉ์ด๊ฐ์ผ๋ฉด ํญ์ ๋์ผํ ํด์์ฝ๋๊ฐ์ ์ป์ 
  - ๋ง์ฝ str1 == str2 == "HELLO" ๋ผ๋ฉด  str1.hashCode(), str2.hashCode()์ ๊ฐ์ ๊ฐ์
  - but, System.identityHashCode(str1), System.identityHashCode(str2)์ ๊ฐ์ ๋ค๋ฆ

#### toString
- ์ธ์คํด์ค์ ๋ํ ์ ๋ณด๋ฅผ ๋ฌธ์์ด๋ก ์ ๊ณตํ  ๋ชฉ์ ์ผ๋ก ์ ์

#### clone
- ์์ ์ ๋ณต์ ํ์ฌ ์๋ก์ด ์ธ์คํด์ค๋ฅผ ์์ฑ

ex)
```java
class Point implements Cloneable { // Cloneable ์ธํฐํ์ด์ค๋ฅผ ๊ตฌํํ ํด๋์ค์์๋ง clone() ํธ์ถ ๊ฐ๋ฅ
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
      obj = super.clone(); // clone()์ ๋ฐ๋์ ์์ธ์ฒ๋ฆฌ ํด์ฃผ์ด์ผํจ
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

#### Stringํด๋์ค

- ๋ณ๊ฒฝ ๋ถ๊ฐ๋ฅํ(immutable) ํด๋์ค
- ๋ฌธ์์ด์ ์ ์ฅํ๊ณ  ์ด๋ฅผ ๋ค๋ฃจ๋๋ฐ ํ์ํ ๋ฉ์๋๋ฅผ ์ ๊ณต
- ๋ง์ ์ฐ์ฐ์ '+'๋ฅผ ์ฌ์ฉํ์ฌ ๋ฌธ์์ด์ ๊ฒฐํฉํ๋ ๊ฒ์ ์ฐ์ฐ ์ ๋ง๋ค ์๋ก์ด ๋ฌธ์์ด์ ๊ฐ์ง String์ธ์คํด์ค๊ฐ ์์ฑ๋์ด ๋ฉ๋ชจ๋ฆฌ ๊ณต๊ฐ ์ฐจ์ง


```
String s = new String("Hello");              -> s = "Hello"

char[] c = {'H', 'e', 'l', 'l', 'o '};
String s = new String(c);                    -> s = "Hello"

StringBuffer sb = new StringBuffer("Hello");
String s = new String(sb);                   -> s = "Hello"

```

#### ๋ฌธ์ ์ธ์ฝ๋ฉ ๋ณํ
- getBytes() ์ฌ์ฉํ๋ฉด ๋ฌธ์์ด์ ๋ฌธ์ ์ธ์ฝ๋ฉ์ ๋ค๋ฅธ ์ธ์ฝ๋ฉ์ผ๋ก ๋ณ๊ฒฝ ๊ฐ๋ฅ
```
byte[] utf8_str = "๊ฐ".getBytes("UTF-8");    // ๋ฌธ์์ด์ UTF-8๋ก ๋ณํ
String str = new String(utf8_str, "UTF-8"); // byte๋ฐฐ์ด์ ๋ฌธ์์ด๋ก ๋ณํ
```

#### StringBufferํด๋์ค์ StringBuilderํด๋์ค

- StringBufferํด๋์ค
```
- ์ธ์คํด์ค๋ฅผ ์์ฑํ  ๋ ๋ฌธ์์ด ๋ณ๊ฒฝ์ด ๊ฐ๋ฅ
- ์ธ์คํด์ค ์์ฑ์ ๊ทธ ํฌ๊ธฐ๋ฅผ ์ง์  ๊ฐ๋ฅ
- equals๋ฉ์๋๋ฅผ ์ค๋ฒ๋ผ์ด๋ฉํ์ง ์์์ equals๋ฉ์๋๋ฅผ ์ฌ์ฉํ์ฌ๋ "=="๋ฅผ ์ฌ์ฉํ๋ ๊ฒ๊ณผ ๊ฐ์ ๊ฒฐ๊ณผ๋ฅผ ์ป์
```

