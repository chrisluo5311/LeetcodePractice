package array;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays350 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        int[] result = intersect(nums1, nums2);
        for (int i : result){
            System.out.println(i);
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        // initialize dictionary
        Map<Integer,Integer> seen = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // put nums1 into seen
        for (int i : nums1){
            if (seen.containsKey(i)){
                seen.put(i,seen.get(i)+1);
                continue;
            }
            seen.put(i,1);
        }

        // check if n in nums2 is in nums1 and result
        for (int n : nums2) {
            if (seen.containsKey(n) && seen.get(n)!=0){
                result.add(n);
                seen.put(n,seen.get(n)-1);
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}
