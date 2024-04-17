package test;

import java.util.HashMap;

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

        // loop through values
        for (String values : map.values()){
            System.out.println(values);
        }
    }
}
