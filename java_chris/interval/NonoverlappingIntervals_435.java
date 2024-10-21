package interval;

import java.util.Arrays;
import java.util.Comparator;

public class NonoverlappingIntervals_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int k = Integer.MIN_VALUE;
        int ans = 0;

        for (int[] arr : intervals) {
            int x = arr[0];
            int y = arr[1];
            if (x >= k) {
                k = y;
            } else {
                ans++;
            }
        }
        return ans;
    }
}
