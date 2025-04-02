package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class subsetII_90 {

    static LinkedList<Integer> tmp = new LinkedList<>();;
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        res.add(tmp);
        // Remember to sort nums so that the duplicate can be found
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    static void backtrack(int[] nums, int start) {
        for (int i = start ; i < nums.length ; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }

            tmp.add(nums[i]);
            res.add(new ArrayList<>(tmp));
            backtrack(nums, i+1);
            tmp.removeLast();
        }
    }

    public static void main(String[] args) {
//        List<List<Integer>> new_res = subsetsWithDup(new int[]{1, 2, 2});
        List<List<Integer>> new_res = subsetsWithDup(new int[]{4, 4, 4, 1, 4});
        for (List<Integer> list : new_res) {
            System.out.println(list);
        }
    }
}
