package test;

import java.util.ArrayList;
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
        System.out.println(test);
        System.out.println(test == 4);
    }
}
