package chapter07.day12;

public class PackageTest {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
/*
* 위 예제 작성 후 '-d' 옵션을 주어 shell에서 실행하게되면?
* C:\jdk1.8/work>javac -d . PackageTest.java
*
* '-d' : 소스파일에 지정된 경로를 통해 패키지 위치 찾아 클래스파일 생성
* if) 지정된 패키지와 일치하는 디렉토리가 존재하지 않는다면? 자동으로 생성
* '-d'옵션 뒤에는 해당 패키지의 루트(root)디렉토리의 경로를 적어줌  (.)은 현재 디렉토리
* 루트 디렉토리를 클래스패스에 포함시켜야만 실행 시 JVM이 PackageTest클래스를 찾을 수 있음
* */
