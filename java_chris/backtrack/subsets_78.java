package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class subsets_78 {

    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> tmp = new LinkedList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>(tmp));
        backtrack(nums, 0);
        return res;
    }

    static void backtrack(int[] nums, int start) {
        if (start >= nums.length) {
            return;
        }

        for (int i = start; i < nums.length ; i++) {
            tmp.add(nums[i]);
            res.add(new ArrayList<Integer>(tmp));
            backtrack(nums, i+1);
            tmp.removeLast();
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = subsets(nums);
        System.out.println(res);
    }
}
