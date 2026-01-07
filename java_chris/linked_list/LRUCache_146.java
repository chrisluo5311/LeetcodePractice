package linked_list;

import java.util.LinkedHashMap;

public class LRUCache_146 {
    int cap;
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    public LRUCache_146(int capacity) {
        cap = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            makeRecently(key);
            return;
        }
        // check cap if full
        if (map.size() >= cap) {
            // delete toppest = oldest
            int top_key = map.keySet().iterator().next();
            map.remove(top_key);
        }

        map.put(key, value);
    }

    public void makeRecently(int key) {
        int value = map.get(key);
        map.remove(key);
        map.put(key, value);
    }
}
