package chapter09.day19;

public class StringEx3 {
    public static void main(String[] args) {
        char[] cArr = new char[0];    // char[] cArr = {}; 과 같음
        String s = new String(cArr);  // String s = new String(""); 와 같음

        System.out.println("cArr.length=" + cArr.length);
        System.out.println("@@@" + s + "@@@");
    }
}
