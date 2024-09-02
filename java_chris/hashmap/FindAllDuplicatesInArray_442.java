package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllDuplicatesInArray_442 {

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> output = new ArrayList<>();
        HashMap<Integer,Integer> dic = new HashMap<>();

        for (int i : nums){
            if (dic.containsKey(i)){
                dic.put(i,dic.get(i)+1);
            } else {
                dic.put(i,1);
            }
        }

        for (Map.Entry<Integer,Integer> entry : dic.entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value > 1){
                output.add(key);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> output = findDuplicates(nums);
        System.out.println(output);
    }
}
