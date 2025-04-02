package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayIndex {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        // start index 3
        int x = 2;
        double test = (double) x * x;
//        System.out.println(test);
        System.out.println(test == 4);


        arr.sort((a,b) -> a-b);
        arr.forEach(System.out::println);


        System.out.println("=================================");
        int[][] intervals = new int[][]{{3,4}, {1,2},{5,6}};
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[i].length; j++) {
                System.out.print(intervals[i][j] + " ");
            }
        }
    }
}
