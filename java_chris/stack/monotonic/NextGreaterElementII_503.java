package stack.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII_503 {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] nextGreater = new int[n];
        Arrays.fill(nextGreater, -1);

        for (int j = 0 ; j < 2; j++) {
            for (int i = 0 ; i < n ; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    int currIndex = stack.pop();
                    nextGreater[currIndex] = nums[i];
                }
                stack.push(i);
            }
        }


        return nextGreater;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1};
        int[] res = nextGreaterElements(nums);
        System.out.println(Arrays.toString(res));
    }
}
