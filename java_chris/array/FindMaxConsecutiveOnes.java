package array;

import java.util.ArrayList;
import java.util.List;

public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,0,1,1,1};
        int nlen = nums.length;
        List<Integer> track = new ArrayList<>();
        int maxLen = 0;
        for (int i = 0; i < nlen;i++){
            if (nums[i] == 1) {
                maxLen++;
                continue;
            }
            track.add(maxLen);
            maxLen = 0;
        }
        track.add(maxLen);

        int result = 0;
        for (int i : track){
            result = Math.max(i, result);
        }
        System.out.println(result);
    }
}
