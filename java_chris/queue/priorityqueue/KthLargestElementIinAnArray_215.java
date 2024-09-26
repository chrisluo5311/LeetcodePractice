package queue.priorityqueue;

import java.util.PriorityQueue;

public class KthLargestElementIinAnArray_215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.add(i);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.remove();
    }
}
