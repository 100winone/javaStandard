package chapter07.day14;

public class CastingTest1 {
    public static void main(String[] args) {
        Car car = null;
        FireEngine fe = new FireEngine();
        FireEngine fe2 = null;

        fe.water();
        car = fe; // car = (Car)fe;에서 형변환 생략된 형태
//        car.water(); // 컴파일 에러, Car타입의 참조변수로는 water()호출 불가
        fe2 = (FireEngine) car;
        fe2.water();
    }
}
class Car{
    String color;
    int door;

    void drive() {
        System.out.println("drive, Brrrr~");
    }
    void stop() {
        System.out.println("stop!!!");
    }
}
class FireEngine extends Car{
    void water() {
        System.out.println("water!!!");
    }
}
