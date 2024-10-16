package queue.priorityqueue;

import java.util.PriorityQueue;

public class Find_Median_from_Data_Stream_295 {
    static class MedianFinder {
        PriorityQueue<Integer> small;
        PriorityQueue<Integer> large;

        public MedianFinder() {
            large = new PriorityQueue<>();
            small = new PriorityQueue<>((a,b) -> b-a);
        }

        public void addNum(int num) {
            if (small.size() >= large.size()) {
                small.offer(num);
                large.offer(small.poll());
            } else {
                large.add(num);
                small.add(large.poll());
            }
        }

        public double findMedian() {
            if (small.size() > large.size()) {
                return small.peek();
            } else if (large.size() > small.size()) {
                return large.peek();
            }

            return (small.peek() + large.peek()) / 2.0;
        }
    }
}
