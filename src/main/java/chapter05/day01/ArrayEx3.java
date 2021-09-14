package chapter05.day01;

public class ArrayEx3 {
    public static void main(String[] args) {
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++)
            arr[i] = i + 1;
        System.out.println("변경 전 - arr.length:" + arr.length);
        for (int i = 0; i < arr.length; i++)
            System.out.println("arr["+ i + "]:"+arr[i]);
        int[] tmp = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++)
            tmp[i] = arr[i];
        arr = tmp;
        System.out.println("변경 후 - arr.length:" + arr.length);
        for (int i = 0; i < arr.length; i++)
            System.out.println("arr["+ i + "]:"+arr[i]);
        // 배열 복사는 System.arraycopy() 사용하는 것이 효과적
    }
}
