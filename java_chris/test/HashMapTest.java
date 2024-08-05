package test;

import java.util.HashMap;
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

    }
}
