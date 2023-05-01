package array;

import java.util.Arrays;

/**
 * @author chris
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        //左半邊
        res[0] = findStartingResult(nums,target);
        //右半邊
        res[1] = findEndingResult(nums,target);
        return res;
    }

    public int findStartingResult(int[] nums, int target){
        //預設-1
        int result = -1;
        int left = 0;
        int right = nums.length - 1;
        //binary search
        while (left <= right){
            int mid = left + (right - left)/2;
            // 唯一不同點在於>=，用意為即便找到與target同樣的值，仍要繼續往「前面」尋找第一個出現的
            if (nums[mid] >= target){
                right = mid -1;
            } else {
                left = mid + 1;
            }

            //紀錄每次找到與target相同值的index，即便往前找沒有同值了也會留記錄
            if (nums[mid] == target){
                result = mid;
            }
        }
        return result;
    }

    public int findEndingResult(int[] nums,int target){
        int result = -1;
        int left = 0;
        int right = nums.length - 1;
        //binary search
        while (left <= right){
            int mid = left + (right - left)/2;
            // 唯一不同點在於>=，用意為即便找到與target同樣的值，仍要繼續往「後面」尋找最後一個出現的
            if (nums[mid] <= target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }

            if (nums[mid] == target){
                result = mid;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray ff = new FindFirstAndLastPositionOfElementInSortedArray();
        //Output: [3,4]
        Arrays.stream(ff.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)).forEach(System.out::println);
    }
}
