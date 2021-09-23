package chapter07.day10;

/*class Tv{
    boolean power;
    int channel;

    void power(){
        power = !power;
    }
    void channelUp(){
        ++channel;
    }
    void channelDown(){
        --channel;
    }
} 이미 선언되어있으므로 주석처리*/
class VCR {
    boolean power;
    int counter = 0;
    void power(){
        power = !power;
    }
    void play(){
        /* 내용생략 */
    }

}
public class TVCR extends Tv{
    VCR vcr = new VCR(); // Tv 클래스를 조상으로 하고, VCR클래스는 TVCR 클래스에 포함신키는 방식으로 사용
    int counter = vcr.counter;
    void play(){
        vcr.play();
    }
}
