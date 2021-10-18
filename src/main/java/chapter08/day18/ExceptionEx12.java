package chapter08.day18;

public class ExceptionEx12 {
    public static void main(String[] args) throws Exception{ // 같은클래스 내의 static멤버이므로 객체생성없이 직접 호출 가능
        method1();
    }
    static void method1() throws Exception{
        method2();
    }
    static void method2() throws Exception{
        throw new Exception();
    }
}
