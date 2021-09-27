package chapter07.day14;

public class CastingTest2 {
    public static void main(String[] args) {
        Car car = new Car();
        Car car2 = null;
        FireEngine fe = null;

        car.drive();
//        fe = (FireEngine)car; // car가 참조하고 있는 인스턴스가 Car타입의 인스턴스이므로 컴파일은 OK지만 실행시 에러 발생
        fe.drive();
        car2 = fe;
        car2.drive();
    }
}
