package test;

import java.util.*;
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
            dic.put(c,dic.getOrDefault(c,0)+1);

        }
        for (Map.Entry<Character,Integer> entry : dic.entrySet()){
            System.out.print(entry.getKey());
            System.out.println(entry.getValue());
        }
        System.out.println(List.of(dic));


        System.out.println("================================");
        // entrySet
        HashMap<String, Integer> test2 = new HashMap<>();
        test2.put("chris",1);
        test2.put("jack",2);
        test2.put("hakunamatata",3);
        for (Map.Entry<String,Integer> entry: test2.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }




        ///
        System.out.println("================================");
        Map<String, List<String>> res = new HashMap<>();
        List<String> tmp = res.getOrDefault("eat",new ArrayList<>());
        tmp.add("aet");
        System.out.println(res.size());
    }
}
