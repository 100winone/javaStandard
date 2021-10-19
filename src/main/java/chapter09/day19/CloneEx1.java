package chapter09.day19;

class Point implements Cloneable { // Cloneable 인터페이스를 구현한 클래스에서만 clone() 호출 가능
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "x=" + x + ", y= " + y;
    }
    public Object clone(){
        Object obj = null;
        try{
            obj = super.clone(); // clone()은 반드시 예외처리 해주어야함
        } catch(CloneNotSupportedException e){}
        return obj;
    }
}
public class CloneEx1 {
    public static void main(String[] args) {
        Point original = new Point(3, 5);
        Point copy = (Point) original.clone();
        System.out.println(original);
        System.out.println(copy);
    }
}
