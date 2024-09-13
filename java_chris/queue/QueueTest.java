package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ✅Boolean offer() – 添加成功返回 True；失敗返回 False。
 * Boolean add(E e) – 添加成功返回 True；失敗則丟出 IllegalStateException。
 * ✅Object poll() – 刪除成功返回第一個 element；失敗返回 null。
 * Object remove() – 刪除成功返回第一個 element；失敗（當queue為空）則丟出 NoSuchElementException。
 * ✅Object peek() – 返回第一個 element，當 queue 為空返回 null。
 * Object element() – 返回第一個 element，當 queue 為空會丟出 NoSuchElementException。
 * */
public class QueueTest {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();

        //offer & add
        queue.offer(1);
        queue.add(2);
        System.out.println("queue: "+queue);

        //remove & poll
        Integer a = queue.remove();
        System.out.println("remove: "+a);
        System.out.println("queue: "+queue);
        Integer b = queue.poll();
        System.out.println("poll: "+b);
        System.out.println("queue: "+queue);

        //isEmpty
        System.out.println("queue isEmpty: "+queue.isEmpty());

        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        System.out.println("queue: "+queue);

        //element & peek
        Integer c = queue.element();
        Integer d = queue.peek();
        System.out.println("element: "+c);
        System.out.println("peek: "+d);

        //size
        System.out.println("queue size: "+queue.size());
    }
}
