package stack.monotonic;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrevAndNextGreaterIndexFinder {

    static List<int[]> findNextAndPrevGreaterIndex(int[] arr) {
        List<int[]> result = new ArrayList<int[]>();
        int n = arr.length;
        int[] prevGear = new int[n];
        int[] nextGear = new int[n];
        Arrays.fill(prevGear,-1);
        Arrays.fill(nextGear,-1);
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                int currIndex = stack.pop();
                nextGear[currIndex] = i;
            }

            if (!stack.isEmpty()) {
                prevGear[i] = stack.peek();
            }
            stack.push(i);
        }

        result.add(prevGear);
        result.add(nextGear);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{13, 8, 1, 5, 2, 5, 9, 7, 6, 12};
        List<int[]> result = findNextAndPrevGreaterIndex(arr);
        for (int[] i : result) {
            for (int j : i) {
                System.out.print(j + ",");
            }
            System.out.println();
        }
    }
}
