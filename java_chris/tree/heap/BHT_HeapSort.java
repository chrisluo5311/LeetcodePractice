package tree.heap;

import java.util.Arrays;

public class BHT_HeapSort {

    public static void heapsort_ascending(int[] nums) {
        // step 01: convert to BHT
        MaxHeap maxHeap = new MaxHeap(nums);
        maxHeap.buildHeap();

        // step 02: remove n times, each time we pick one max to current end position
        int i = nums.length - 1;
        while (true) {
            if (i < 0) break;

            maxHeap.remove_from_top();

            i--;
        }
    }

    public static void main(String[] args) {
        /** HeapSort **/
        int[] num = {66,78,27,35,6,2,44,58,29,76};
        heapsort_ascending(num);
        System.out.println();
    }
}
