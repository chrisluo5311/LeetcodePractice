package classic_algorithms;

public class BubbleSort {
    public static void sortBubble(int[] nums){
        for (int round = 0; round < nums.length; round++){
            // 優化：省下已經排好的跑者，不用再比較
            int len = nums.length - round;
            for (int i = 1; i < len; i++){
                if (nums[i-1] > nums[i]) {
                    swap(nums,i-1,i);
                }
            }
        }
    }

    private static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8,2,6,10,4};
        sortBubble(nums);

        System.out.println();
    }
}
