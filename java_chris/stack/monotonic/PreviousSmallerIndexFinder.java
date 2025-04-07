package stack.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class PreviousSmallerIndexFinder {

    static int[] previousSmallerIndexes(int[] arr) {
        int n = arr.length;
        int[] smallerGear = new int[n];
        Arrays.fill(smallerGear, -1);
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                smallerGear[i] = stack.peek();
            }
            stack.push(i);
        }
        return smallerGear;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{13, 8, 1, 5, 2, 5, 9, 7, 6, 12};
        int[] smallerGear = previousSmallerIndexes(arr);
        for (int i : smallerGear) {
            System.out.print(i+",");
        }
    }
}
