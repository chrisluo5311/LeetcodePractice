package queue.priorityqueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  二元堆 (Binary Heap)
 *  1. MinHeap: PriorityQueue預設就是MinHeap，即每個節點下方的所有節點的值都比它大
 *  2. MaxHeap: 改寫Comparator的compare方法，讓根節點就是整棵樹的最大值
 * */
public class PriorityQueueTest {

    static class Person {
        Integer age;
        Integer peepee_wait_time;
        public Person(Integer age, Integer peepee_wait_time) {
            this.age = age;
            this.peepee_wait_time = peepee_wait_time;
        }
    }

    static class MyComp implements Comparator<Person> {

        @Override
        public int compare(Person p1, Person p2) {
            // 預設是「小 -> 大」
            // 加個負號改為「大 -> 小」
            return -p1.peepee_wait_time.compareTo(p2.peepee_wait_time);
        }
    }

    public static void maxHeap() {
        System.out.println("Max Heap");
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

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

    // 时间复杂度 O(NlogN)，空间复杂度 O(N)
    public static int[] heapSort(int[] arr) {
        int[] res = new int[arr.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.stream(arr).forEach(pq::add);
        // 元素出堆的顺序是有序的
        for (int i = 0; i < arr.length; i++) {
            res[i] = pq.remove();
        }
        return res;
    }

    public static void main(String[] args) {
        // minHeap
//        minHeap();

        // maxHeap
        maxHeap();
        System.out.println();

        // time complexity for each method
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // add - time complexity O(logN)
        pq.add(10);
        pq.add(2);
        pq.add(900);
        pq.add(7);
        System.out.println("PriorityQueue: "+pq);

        // peek - O(1)
        int currTop = pq.peek();
        System.out.println("1. Peek: "+ currTop);

        // poll, remove the top element - O(logN)
        int currRemove = pq.remove();
        System.out.println("2. Remove top element: "+currRemove);
        System.out.println("3. Current PriorityQueue: "+pq);

        // size - O(1)
        System.out.println("4. PriorityQueue size: "+pq.size());

        // heap sort
        System.out.print("5. Max Heap: ");
        int[] arr = new int[]{2,80,6,3,1,399,53};
        arr = heapSort(arr);
        for (int i : arr){
            System.out.print(i+",");
        }

        // custom comparator
        System.out.println("6. Custom Comparator: ");
        Person[] ppl = new Person[] {
                new Person(19, 60)
                ,new Person(28, 45)
                ,new Person(48, 32)
                ,new Person(60, 19)
                ,new Person(33, 200)
        };
        PriorityQueue<Person> pq1 = new PriorityQueue<>(ppl.length,new MyComp());
        for (int i = 0; i < ppl.length; i++) {
            pq1.add(ppl[i]);
        }

        System.out.println("peepee wait time: ");
        while (!pq1.isEmpty()) {
            Person p = pq1.poll();
            System.out.print(p.peepee_wait_time + " ");
        }

    }
}
