package chapter07.day16;

public class InterfaceTest3 {
    public static void main(String[] args) {
        A3 a = new A3();
        a.methodA();
    }
}

class A3{
    void methodA(){
        I3 i = InstanceManager.getInstance(); // 제3의 클래스 메서드를 통해서 인터페이스 I를 구현한 클래스의 인스턴스를 얻어온다.
        i.methodB();
        System.out.println(i.toString());
    }
}
interface I3{
    public abstract void methodB();
}
class B3 implements I3 {
    public void methodB(){
        System.out.println("methodB in B class");
    }
    public String toString(){ return "class B";}
}

class InstanceManager {
    public static I3 getInstance(){
        return new B3();
    }
}
