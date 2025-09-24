package tree.heap;

public class MaxHeapTest {
    public static void main(String[] args) {
        int[] nums = new int[]{66,78,27,35,6,2,44,58,29,76};

        // build heap
        MaxHeap maxHeap = new MaxHeap(nums);
        maxHeap.buildHeap();
        System.out.println();

        // remove
        maxHeap.remove_from_top();
        System.out.println();

        /// add
        maxHeap.add_to_bottom(100);
        maxHeap.add_to_bottom(120);
        System.out.println();
    }
}
