package array;

import java.util.ArrayList;
import java.util.List;

public class FourDivisors {
    public static int sumFourDivisors(int[] nums) {
        // 42: square root of 42 is 6..., so find 1, 2, 3, ... 6
        // 1, 2, 3, 6 | 7, 14, 21, 42
        int sum = 0;
        for (int i = 0; i < nums.length ; i++) {
            sum += findDivisor(nums[i]);
        }
        return sum;
    }

    static int findDivisor(int num) {
        int mid = (int) Math.sqrt(num);
        int cnt = 0;
        List<Integer> track = new ArrayList<>();

        for (int i = 1 ; i <= mid ; i++) {
            if (num%i == 0) {
                int quotient = num/i;
                if (quotient == i) { // prevent duplicate
                    cnt += 1;
                    track.add(i);
                    continue;
                }
                cnt += 2;
                track.add(i);
                track.add(num/i);
            }
        }

        if (cnt == 4) {
            int sum = 0;
            for (int j : track) {
                sum += j;
            }
            return sum;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {21,4,7};
        int res = sumFourDivisors(nums);
        System.out.printf("%d\n", res); // 32

        int[] nums2 = {21, 21};
        int res2 = sumFourDivisors(nums2);
        System.out.println(res2); // 64
    }
}
