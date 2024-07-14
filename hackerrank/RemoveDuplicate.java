import java.util.Arrays;
import java.util.HashMap;

public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int len = nums.length;
        int fast = len-1;
        int slow = len-1;
        int countRemove = 0;
        HashMap<Integer,Integer> checkNum = new HashMap<>();
        while(fast >= 0){
            if (checkNum.containsKey(nums[fast])){
                for (int i = fast+1; i < slow ; i++){
                    nums[i] = nums[i+1];
                }
                nums[slow--] = -1;
                fast--;
                countRemove++;
                continue;
            }
            checkNum.put(nums[fast],1);
            fast--;
        }
        System.out.println(len - countRemove);
        System.out.println(Arrays.toString(nums));
    }
}
