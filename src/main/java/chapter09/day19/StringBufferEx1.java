package chapter09.day19;

public class StringBufferEx1 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("abc");
        StringBuffer sb2 = new StringBuffer("abc");

        System.out.println("sb == sb ? " + (sb == sb2));
        System.out.println("sb.equals()sb2 ? " + (sb.equals(sb2)));

        String s = sb.toString(); // String s = new String(sb); 와 같음
        String s2 = sb.toString();

        System.out.println("s.equals(s2) ? " + s.equals(s2));

    }
}
