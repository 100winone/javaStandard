package chapter11.day22;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueEx {
    public static void main(String[] args) {
        Queue pq = new PriorityQueue();
        pq.offer(3);
        pq.offer(1);
        pq.offer(5);
        pq.offer(2);
        pq.offer(4);
        System.out.println(pq); // pq의 내부배열 출력

        Object obj = null;

        // PriorityQueue에 저장된 요소를 하나씩 꺼냄
        while ((obj = pq.poll()) != null) {
            System.out.println(obj);
        }
    }
}
