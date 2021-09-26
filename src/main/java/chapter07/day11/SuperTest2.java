package chapter07.day11;

public class SuperTest2 {
    public static void main(String[] args) {
        Child c = new Child();
        c.method();
    }
}
class Child extends Parent{
    int x = 20;
    void method() {
        System.out.println("x=" + x);
        System.out.println("this.x=" + this.x); // 자손 클래스에 선언된 x
        System.out.println("super.x=" + super.x); // 조상 클래스로부터 상속받은 멤버변수 x
    }
}

/* superTest에 이미 정의

class Parent{
    int x = 10;
}

*/
