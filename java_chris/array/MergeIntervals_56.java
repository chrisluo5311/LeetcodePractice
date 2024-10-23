package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals_56 {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> res = new LinkedList<>();
        for (int[] arr: intervals){
            if (res.isEmpty() || res.getLast()[1] < arr[0]) {
                res.add(arr);
            } else {
                res.getLast()[1] = Math.max(res.getLast()[1], arr[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
