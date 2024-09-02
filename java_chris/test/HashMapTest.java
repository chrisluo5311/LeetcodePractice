package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<String,String>();
        //add
        map.put("key1","banana");
        map.put("key2","chris");
        map.put("key3","jack");
        //access
        map.get("key1");
        //remove
        map.remove("key1");
        //remove all
        //map.clear();
        // hashmap size
        System.out.println(map.size());
        // loop through map
        for (String key : map.keySet()){
            System.out.println(key);
        }

        //update
        map.put("key2","hakunamatata");

        // loop through values
        for (String values : map.values()){
            System.out.println(values);
        }

        HashMap<Integer,Integer> map2 = new HashMap<Integer,Integer>();
        //add
        map2.put(0,1);
        map2.put(1,0);
        map2.put(2,2);
        map2.put(3,0);
        int k = 1;


        System.out.println("================================");
        // 字串
        String s = "strrt";
        HashMap<Character,Integer> dic = new HashMap<>();
        for (char c : s.toCharArray()){
            if (dic.containsKey(c)){
                dic.put(c,dic.get(c)+1);
            } else {
                dic.put(c,1);
            }
        }
        for (Map.Entry<Character,Integer> entry : dic.entrySet()){
            System.out.print(entry.getKey());
            System.out.println(entry.getValue());
        }
        System.out.println(List.of(dic));

    }
}
