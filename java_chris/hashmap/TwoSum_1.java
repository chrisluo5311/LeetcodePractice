package hashmap;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> dic = new HashMap<>();
        int index = 0;
        for (int i : nums){
            int tmp = target - i;
            if (dic.containsKey(tmp)){
                int index2 = dic.get(tmp);
                return new int[]{index,index2};
            } else {
                dic.put(i,index++);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        Arrays.stream(result).forEach(System.out::println);
    }
}
