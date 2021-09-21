package chapter06.day06;

public class MemberCall {
    int iv = 10;
    static int cv = 20;

    int iv2 = cv;
    //static int cv2 = iv // error, 클래스 변수는 인스턴스변수를 사용할 수 없음
    static int cv2 = new MemberCall().iv; // 이렇게 객체 생성 해야함

    static void staticMethod1() {
        System.out.println(cv);
//        System.out.println(iv); 에러. 클래스메서드에서 인스턴스변수 사용 불가
        MemberCall c = new MemberCall(); // 이처럼 객체 생성해주어야 인스턴스 변수 사용가능
        System.out.println(c.iv);
    }

    void instanceMethod1() {
        System.out.println(cv);
        System.out.println(iv); // 인스턴스 메서드에서는 인스턴스변수 사용 가능
    }

    static void staticMethod2() {
        staticMethod1();
//        instanceMethod1(); 에러. 클래스메서드에서 인스턴스메서드 사용 불가
        MemberCall c = new MemberCall(); // 이처럼 객체 생성해주어야 인스턴스 변수 사용가능
        c.instanceMethod1();
    }

    void instanceMethod2() {
        staticMethod1();
        instanceMethod1();
    }
}
