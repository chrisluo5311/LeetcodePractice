package classic_algorithms;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] nums){
        for (int i_start = 0; i_start < nums.length; i_start++) {
            int i_max = i_start;
            for (int j_start = i_start + 1; j_start < nums.length; j_start++) {
                if (nums[j_start] > nums[i_max]){
                    i_max = j_start;
                }
            }
            swap(nums, i_start, i_max);
        }
    }

    public static void selectionSort_recursion(int[] nums){
        int i_start = 0;
        selectionSort_recursion_helper(nums, i_start);
    }

    private static void selectionSort_recursion_helper(int[] nums, int i_start) {
        if (i_start >= nums.length) {
            return;
        }
        int i_max = i_start;
        int j_start = i_start + 1;
        i_max = selectionSort_recursion_helper02(nums, i_max, j_start);

        swap(nums, i_start, i_max);

        selectionSort_recursion_helper(nums,i_start+1);
    }

    private static int selectionSort_recursion_helper02(int[] nums, int i_max, int j_start) {
        if (j_start >= nums.length) {
            return i_max;
        }
        if (nums[j_start] > nums[i_max]){
            i_max = j_start;
        }

        return selectionSort_recursion_helper02(nums, i_max, j_start+1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,8,3,9,4,7,2};
//        selectionSort(nums);
        selectionSort_recursion(nums);
        Arrays.stream(nums).forEach(System.out::print);

    }
}
