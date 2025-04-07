package stack.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class PreviousGreaterIndexFInder {

    static int[] findPreviousGreaterIndex(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<Integer>();
        int[] previousGear = new int[n];
        Arrays.fill(previousGear,-1);

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                previousGear[i] = stack.peek();
            }
            stack.push(i);
        }
        return previousGear;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{13, 8, 1, 5, 2, 5, 9, 7, 6, 12};
        int[] res = findPreviousGreaterIndex(arr);
        System.out.println(Arrays.toString(res));

    }
}
