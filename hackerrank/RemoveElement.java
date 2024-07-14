import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        //
        int len = nums.length;
        int r = len -1, s = len-1;
        int countRemove = 0;
        while (r >= 0){
            if (nums[r] == val){
                nums[r] = -1;
                int temp = nums[s];
                nums[s] = nums[r];
                nums[r] = temp;
                s--;
                r--;
                countRemove++;
                continue;
            }
            r--;
        }
        System.out.println(countRemove + ", nums = " + Arrays.toString(nums));
    }
}
