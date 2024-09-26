package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KthLargestElementInAnArray_215 {

    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums){
            list.add(i);
        }
        return quickSelect(list, k);
    }

    public int quickSelect(List<Integer> list, int k){
        int randomPivotIndex = new Random().nextInt(list.size());
        int pivot = list.get(randomPivotIndex);

        List<Integer> left = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int num : list) {
            if (num > pivot) {
                left.add(num);
            } else if (num < pivot) {
                right.add(num);
            } else {
                mid.add(num);
            }
        }

        if (left.size() >= k) {
            return quickSelect(left,k);
        }

        if (left.size() + mid.size() < k) {
            return quickSelect(right, k - left.size() - mid.size());
        }
        return pivot;
    }
}
