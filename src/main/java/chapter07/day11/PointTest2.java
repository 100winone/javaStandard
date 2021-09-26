package chapter07.day11;

public class PointTest2 {
    public static void main(String[] args) {
        Point3E p3 = new Point3E();
        System.out.println("p3.x=" + p3.x);
        System.out.println("p3.y=" + p3.y);
        System.out.println("p3.z=" + p3.z);
    }
}

class Point2 {
    int x = 10;
    int y = 20;

    Point2(int x, int y) {
        // super();는 조상인 Object(); 를 호출함
        this.x = x;
        this.y = y;
    }
}

class Point3E extends Point2 {
    int z = 30;
    Point3E(){
        this(100, 200, 300);
    }

    Point3E(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
}
