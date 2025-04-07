package stack.monotonic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextAndPreviousSmallerIndexFinder {

    static List<int[]> nextAndPreviousSmallerIndexes(int[] arr) {
        List<int[]> result = new ArrayList<int[]>();
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] nextGear = new int[n];
        int[] prevGear = new int[n];
        Arrays.fill(nextGear,-1);
        Arrays.fill(prevGear,-1);

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int currIndex = stack.pop();
                nextGear[currIndex] = i;
            }
            if (!stack.isEmpty()) {
                prevGear[i] = stack.peek();
            }
            stack.push(i);
        }
        result.add(nextGear);
        result.add(prevGear);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{13, 8, 1, 5, 2, 5, 9, 7, 6, 12};
        List<int[]> res = nextAndPreviousSmallerIndexes(arr);
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
