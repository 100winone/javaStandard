package chapter08.day18;

public class ExceptionEx9 {
    public static void main(String[] args) {
        try{
            Exception e = new Exception("고의로 발생시켰음.");
            throw e;
            // throw new Exception("고의로 발생시켰음."); 으로 변경가능
        } catch(Exception e){
            System.out.println("에러 메시지 : " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("프로그램이 정상 종료되었음.");
    }
}
