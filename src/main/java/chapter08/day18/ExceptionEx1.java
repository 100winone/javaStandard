package chapter08.day18;

public class ExceptionEx1 {
    public static void main(String[] args) {
       try {
            try {} catch (Exception e) {}
        } catch (Exception e){
//            try{} catch (Exception e) {} 변수 e의 중복선언으로 error
        }   // try-catch의 끝
        try{

        } catch (Exception e){

        }
    }
}
// catch블럭에 선언된 두 참조변수의 영역이 서로 겹치므로 다른 이름을 사용해야만 서로 구분