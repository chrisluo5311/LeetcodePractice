package classic_algorithms;

public class MergeSort_DFS_PostOrder {

    public static void merge_sort(int[] nums) {
        merge_sort(nums, 0, nums.length - 1);
    }

    public static void merge_sort(int[] nums, int start, int end) {
        if (start == end) return;
        int mid = (start + end) / 2;
        merge_sort(nums, 0, mid);
        merge_sort(nums, mid + 1, end);

        sort_arr(nums, start, mid, end);
    }

    private static void sort_arr(int[] nums, int start, int mid, int end) {
        int[] tmp = new int[nums.length];
        int tmp_index = start;
        int left = start;
        int right = mid + 1;

        while (tmp_index <= end) {
            Integer left_num = null;
            Integer right_num = null;

            if (left <= mid) {
                left_num = nums[left];
            }
            if (right <= end) {
                right_num = nums[right];
            }

            if (null != left_num && null != right_num) {
                if (left_num <= right_num) {
                    tmp[tmp_index] = left_num;
                    left++;
                } else {
                    tmp[tmp_index] = right_num;
                    right++;
                }
            } else if (null != left_num && null == right_num) {
                tmp[tmp_index] = left_num;
                left++;
            } else if (null != right_num && null == left_num) {
                tmp[tmp_index] = right_num;
                right++;
            } else {
                new RuntimeException("Shouldn't this at all");
            }
            tmp_index++;
        }

        // put back into the nums
        int k = start;
        while (k <= end) {
            nums[k] = tmp[k];
            k++;
        }
    }

    public static void main(String[] args) {
        int[] ary = {24,2,45,20,56,75,2,56,99,53,12};
        merge_sort(ary);
        System.out.println();
    }
}
