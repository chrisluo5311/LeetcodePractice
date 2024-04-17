package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array2D {
    public static void main(String[] args) {
        List<List<Integer>> arr = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6),
                Arrays.asList(7,8,9));

        System.out.println(arr);
        for (List<Integer> list : arr) {
            System.out.println(list);
        }

        int n = arr.size();
        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 0 ; i < n ; i++){
            sumLeft += arr.get(i).get(i).intValue();
            sumRight += arr.get(i).get(n-i-1).intValue();
        }

        System.out.println(Math.abs(sumLeft - sumRight));
    }
}
