package stack.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterIndexFinder {
    public static int[] findNextGreaterIndexes(int[] arr) {
        int n = arr.length;
        int[] nextGreater = new int[n];
        Arrays.fill(nextGreater, -1); // initialize with -1 as default value

//        Deque<Integer> stack = new ArrayDeque<>(); // stack to keep indexes
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // While stack is not empty and
            // current element is greater than the element at the index on top of stack
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int topIndex = stack.pop();
                nextGreater[topIndex] = i; // update the index of the next greater element
            }
            stack.push(i); // push current index
        }

        return nextGreater;
    }

    // For testing
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 6, 4};
        int[] result = findNextGreaterIndexes(arr);
        System.out.println("Next Greater Indexes: " + Arrays.toString(result));
    }
}
