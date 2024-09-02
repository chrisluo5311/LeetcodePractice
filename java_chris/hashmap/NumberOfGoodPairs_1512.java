package hashmap;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs_1512 {

    public static int numIdenticalPairs(int[] nums) {
        int count = 0;
        Map<Integer,Integer> dic = new HashMap<>();

        for (int i : nums){
            if (dic.containsKey(i)){
                count += dic.get(i);
                dic.put(i,dic.get(i)+1);
            } else {
                dic.put(i,1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int count = numIdenticalPairs(new int[]{1,2,3,1,1,3});
        System.out.println("Good pairs: "+count);
    }
}
