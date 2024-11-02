package queue.dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeueTest {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        // 插入元素到兩端
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(0);
        deque.addLast(3);

        System.out.println("Deque after insertions: " + deque);

        // 從前端刪除元素
        System.out.println("Removed from front: " + deque.removeFirst());
        // 從後端刪除元素
        System.out.println("Removed from back: " + deque.removeLast());

        System.out.println("Deque after deletions: " + deque);
    }
}
