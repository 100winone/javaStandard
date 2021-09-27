package chapter07.day14;
class Product2{
    int price;
    int bonusPoint;

    Product2(int price){
        this.price = price;
        bonusPoint = (int) (price / 10.0);
    }
    Product2(){} // 기본생성자
}

class Tv2 extends Product2 {
    Tv2(){
        // 조상클래스의 생성자 Product2(int price)를 호출
        super(100); // Tv2 가격 100만원으로
    }
    public String toString(){ // Object클래스의 toString()을 오버라이딩
        return "Tv2";
    }
}
class Computer2 extends Product2{
    Computer2(){
        super(200);
    }
    public String toString(){
        return "Computer2";
    }
}

class Audio2 extends Product2 {
    Audio2(){super(50);}
    public String toString(){
        return "Audio2";
    }
}
class Buyer2{
    int money = 1000;
    int bonusPoint = 0;
    Product2[] item = new Product2[10];
    int i = 0;

    void buy(Product2 p) {
        if (money < p.price) {
            System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
            return;
        }

        money -= p.price;
        bonusPoint += p.bonusPoint;
        item[i++] = p; // 제품을 Product[] item에 저장한다.
        System.out.println(p + "을/를 구입하셨습니다.");
    }

    void summary(){
        int sum = 0;
        String itemList = "";

        for (int i = 0; i < item.length; i++) {
            if(item[i] == null) break;
            sum += item[i].price;
            itemList += item[i] + ", ";
        }
        System.out.println("구입하신 물품의 총금액은 " + sum + "만원입니다.");
        System.out.println("구입하신 제품은 " + itemList + "입니다.");
    }
}

class PolyArgumentTest2 {
    public static void main(String[] args) {
        Buyer2 b = new Buyer2();

        b.buy(new Tv2());
        b.buy(new Computer2());
        b.buy(new Audio2());
        b.summary();
    }
}
