package classic_algorithms;

public class Greedy_JumpGame_55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for (int i = 0; i < n ;i++){
            if (i > farthest){
                return false;
            }
            farthest = Math.max(farthest, i+nums[i]);
        }
        return true;
    }
}
