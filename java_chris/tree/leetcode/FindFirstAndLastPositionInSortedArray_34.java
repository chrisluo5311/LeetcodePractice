package tree.leetcode;

public class FindFirstAndLastPositionInSortedArray_34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1,-1};
        return search_left_right(nums, target, 0, nums.length - 1);
    }

    public int[] search_left_right(int[] nums, int target, int i_start, int i_end) {
        if (i_start > i_end) return new int[]{-1, -1}; // 到了一個Null點
        int[] result = new int[]{-1,-1};
        int[] leftNode;
        int[] rightNode;

        int mid = (i_start + i_end) / 2;
        if (nums[mid] == target) {
            result[0] = mid; // update
            result[1] = mid; // update

            // anything better ?
            // go left subtree
            if (i_start < mid) {
                leftNode = search_left_right(nums, target, i_start, mid - 1);
                if (leftNode[0] != -1) {
                    result[0] = leftNode[0]; // update
                }
            }

            // go right subtree
            if (i_end > mid) {
                rightNode = search_left_right(nums, target, mid + 1, i_end);
                if (rightNode[1] != -1) {
                    result[1] = rightNode[1]; // update
                }
            }
        } else if (nums[mid] < target) {
            // go right
            if (i_end > mid) {
                return search_left_right(nums, target, mid + 1, i_end);
            }
        } else if (nums[mid] > target) {
            // go left
            if (i_start < mid) {
                return search_left_right(nums, target, i_start, mid - 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionInSortedArray_34 obj = new FindFirstAndLastPositionInSortedArray_34();
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        int[] result = obj.searchRange(nums, target);
        System.out.println("[" + result[0] + "," + result[1] + "]");
    }
}
