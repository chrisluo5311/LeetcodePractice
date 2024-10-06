package classic_algorithms;

public class InsertionSort {

    public static void insertionSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i-1; j>= 0; j--) {
                if (nums[j] < nums[j+1]) {
                    swap(nums, j, j+1);
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(int[] nums, int j, int i) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8,2,6,10,4};
        insertionSort(nums);
        System.out.println();
    }
}
