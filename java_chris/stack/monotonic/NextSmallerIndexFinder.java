package stack.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerIndexFinder {

    static int[] findNextSmallerIndexes(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = arr.length;
        int[] smallerGear = new int[n];
        Arrays.fill(smallerGear, -1);
        for (int i = 0 ; i < n ; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                smallerGear[stack.pop()] = i;
            }
            stack.push(i);
        }
        return smallerGear;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{13, 8, 1, 5, 2, 5, 9, 7, 6, 12};
        int[] smallerGear = findNextSmallerIndexes(arr);
        for (int i : smallerGear) {
            System.out.print(i+",");
        }
    }
}
