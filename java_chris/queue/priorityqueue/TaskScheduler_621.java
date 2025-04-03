package queue.priorityqueue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler_621 {
    public static int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i : count) {
            if (i > 0) {
                pq.add(i);
            }
        }

        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        while (!pq.isEmpty() || !queue.isEmpty()) {
            time++;

            if (pq.isEmpty()) {
                //當 maxHeap 是空的（代表沒有任務可以馬上做）
                //直接 time = q.peek()[1]，也就是直接跳到下一個任務能重新執行的時間。
                time = queue.peek()[1];
            } else {
                int cnt = pq.poll() - 1;
                if (cnt > 0) {
                    // put into queue if not zero
                    // key: cnt, value: time + n
                    queue.add(new int[]{cnt, time + n});
                }
            }

            if (!queue.isEmpty() && queue.peek()[1] == time) {
                // take out from queue if current time matches the first element's time
                pq.add(queue.poll()[0]);
            }
        }
        return time;
    }

    public static void main(String[] args) {
        // expected : 8
        char[] task = new char[]{'A','A','A','B','B','B'};
        int time = leastInterval(task, 2);
        System.out.println(time); // 8
    }
}
