package hashmap;

import java.util.HashMap;

public class HashMapTest {

    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<String,Integer>();

        // put, time complexity is O(1)
        map.put("英文",100);
        map.put("國文",59);
        map.put("數學",80);
        map.put("自然",30);
        System.out.println("1. HashMap: " + map);

        //remove, time complexity is O(1)
        map.remove("國文");
        System.out.println("2. After removing 國文, HashMap: " + map);

        // get, time complexity is O(1)
        Integer mathScore = map.get("數學");
        System.out.println("3. Get key 數學, score is : " + mathScore);
    }
}
