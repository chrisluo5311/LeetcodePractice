package array;

/**
 * 33. Search in Rotated Sorted Array
 * Approach: Binary Search
 * Time complexity : O(logN).
 * @author chris
 */
public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length-1;

        // 尋找數列中最小的點
        while (left < right){
            int midPoint = left + (right-left)/2;
            if (nums[midPoint] > nums[right]){
                left = midPoint + 1;
            } else {
                right = midPoint;
            }
        }

        // 找到midpoint後，縮小搜尋範圍
        int startIndex = left;
        left = 0;
        right = nums.length - 1;

        if (target >= nums[startIndex] && target <= nums[right]){
            left = startIndex;
        } else {
            right = startIndex;
        }

        // 標準binary search
        while (left <= right){
            int midpoint = left + (right-left)/2;
            if (target == nums[midpoint]){
                return midpoint;
            } else if (target > nums[midpoint]){
                left = midpoint + 1;
            } else {
                right = midpoint - 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        // Input: nums = [4,5,6,7,0,1,2], target = 0
        // Output: 4
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums,target));

    }
}
