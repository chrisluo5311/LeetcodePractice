package classic_algorithms;

import java.util.Arrays;

public class QuickSort_dfs_preorder {

    static void quicksort(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
    }

    static void quicksort(int[] nums, int start, int end) {
        if (start == end) return;
        if (start > end) return;
        // preorder logic : quick sort
        int tmp = getIndex(start, end);
        int middle = sort(nums, tmp, start, end);

        // go left
        quicksort(nums, start, middle - 1);
        // go right
        quicksort(nums, middle + 1, end);
    }

    private static int sort(int[] nums, int mid, int start, int end) {
        swap(nums, mid, end);
        int l = start;
        int r = end - 1;
        while (l < r) {
            while (l < r && nums[l] < nums[end]) {
                l++;
            }
            while (r > l && nums[r] > nums[end]) {
                r--;
            }
            swap(nums, l, r);
        }
        if (nums[l] > nums[end]) {
            swap(nums, l, end);
        }
        return l;
    }

    private static void swap(int[] nums, int tmp, int end) {
        int tp = nums[end];
        nums[end] = nums[tmp];
        nums[tmp] = tp;
    }

    private static int getIndex(int start, int end) {
        return (start + end) / 2;
    }

    public static void main(String[] args) {
        int[] ary = {20,10,50,30,70,60,40};
        quicksort(ary);
        Arrays.stream(ary).forEach(System.out::println);
        System.out.println();
    }
}
