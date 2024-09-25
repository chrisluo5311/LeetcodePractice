package queue.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  二元堆 (Binary Heap)
 *  1. MinHeap: PriorityQueue預設就是MinHeap，即每個節點下方的所有節點的值都比它大
 *  2. MaxHeap: 改寫Comparator的compare方法，讓根節點就是整棵樹的最大值
 * */
public class PriorityQueueTest {

    public static void maxHeap() {
        System.out.println("Max Heap");
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        // add elements
        maxHeap.add(990);
        maxHeap.add(1);
        maxHeap.add(10);

        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
    }

    public static void minHeap() {
        System.out.println("Min Heap");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // add elements
        pq.add(990);
        pq.add(1);
        pq.add(10);

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }

    public static void main(String[] args) {
        // minHeap
//        minHeap();

        // maxHeap
        maxHeap();
    }
}
