package classic_algorithms;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void quickSort(int[] nums, int low, int high){
        if (low >= high) {
            return;
        }
        int pivot = partition(nums, low, high);
        quickSort(nums,low, pivot-1);
        quickSort(nums,pivot, high);
    }

    public static int partition(int[] nums, int low, int high){
        //randomly pick an index to swap with the last one
        Random random = new Random();
        int toSwapIndex = random.nextInt(high+1);
        swap(nums,high,toSwapIndex);
        // use the last index as pivot
        int pivot = nums[high];
        int i = low - 1; // nums[i] is always <= pivot
        for (int j = low ; j < high; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums,i+1,high);
        return i+1;
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void shuffle(int[] nums){
        Random random = new Random();
        int n = nums.length;
        for (int i = 0; i < nums.length; i++){
            int toSwapIndex = i + random.nextInt(n - i);
            swap(nums, i, toSwapIndex);
        }
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{1,5,9,4,6,2,3};
//        shuffle(test1);//shuffle the entire array
        // or randomly pick an index to swap with the last one
        quickSort(test1,0,test1.length-1);
        Arrays.stream(test1).forEach(System.out::print);
    }
}
