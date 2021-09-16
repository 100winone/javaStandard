package chapter05.day02;

public class ArrayEx14 {
    public static void main(String[] args) {
        String src = "ABCDE";
        for (int i = 0; i < src.length(); i++) {
            char ch = src.charAt(i);
            System.out.println("src.charAt(" + i + "):" + ch);
        }
        char[] chArr = src.toCharArray(); // String 문자열을 char 배열로 변경
        System.out.println(chArr);
    }
}

/*
* String객체는 읽을 수만 있을 뿐 내용을 변경할 수는 없음
* 기본형 변수는 == 을 사용하지만 문자형 비교시에는 equals() 사용해야함.. ex) str.equals("abc")
* char 배열과 String 클래스의 변환 -> String str = new String(chArr) , chArr은 char 배열
* char[] tmp = str.toCharArr(); -> String -> char 배열로 변경

* */
