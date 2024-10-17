package dynamic_programming;

import java.util.ArrayList;

public class LongestIncreasingSubsequence_300 {

    public int arrayListMethod(int[] nums) {
        ArrayList<Integer> track = new ArrayList<>();
        int n = nums.length;
        track.add(nums[0]);

        for (int i = 1 ; i < n ; i++){
            if (nums[i] > track.get(track.size() - 1)){
                track.add(nums[i]);
            } else {
                int j = 0;
                while (nums[i] > track.get(j)) {
                    j++;
                }

                track.set(j,nums[i]);
            }
        }
        return track.size();
    }


    public int dpMethod(int[] nums) {
        int n = nums.length;
        int res = 0;
        int[] dp = new int[nums.length];
        for (int i = 0;i<dp.length;i++){
            dp[i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0;j < i ;j++){
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = 0 ; i < dp.length; i++){
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
