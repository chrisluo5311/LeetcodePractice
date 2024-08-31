package array;

import java.util.Arrays;

public class RearrangeArray_2149 {
    public static void main(String[] args) {
        int[] output = rearrangeArray(new int[]{3,1,-2,-5,2,-4});
        Arrays.stream(output).forEach(System.out::println);
    }

    public static int[] rearrangeArray(int[] nums) {
        int numsLength = nums.length;
        int[] posNums = new int[numsLength/2];
        int[] negNums = new int[numsLength/2];
        int indexPos = 0;
        int indexNeg = 0;
        for (int i : nums){
            if (i < 0){
                negNums[indexNeg++] = i;
            } else {
                posNums[indexPos++] = i;
            }
        }
        int[] output = new int[numsLength];
        for (int i = 0; i < numsLength; i+=2){
            output[i] = posNums[i/2];
            output[i+1] = negNums[i/2];
        }
        return output;
    }
}
