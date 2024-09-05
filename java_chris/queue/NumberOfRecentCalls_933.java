package queue;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls_933 {

    public static void main(String[] args) {
        RecentCounter obj = new RecentCounter();
        int[] pingArray = new int[]{1,100,3001,3002};
        for (int i : pingArray){
            int pinNum = obj.ping(i);
        }
    }
}
class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        int start = t-3000;
        queue.offer(t);

        while(!queue.isEmpty() && queue.element() < start) {
            queue.remove();
        }
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */