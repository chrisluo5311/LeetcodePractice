package queue.priorityqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// 破題：知道PriorityQueue後面排序怎麼使用
public class TopKFrequentElements_347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // 重點：後面排序可以使用class來接，所以直接放key即可
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> map.get(a) - map.get(b));
        for (int i : map.keySet()) {
            pq.add(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
