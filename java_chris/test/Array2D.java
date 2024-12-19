package test;

import java.util.*;

public class Array2D {

    public static void main(String[] args) {
        //transform ArrayList or LinkedList to int array
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        int[] a = arr.stream().mapToInt(i -> i).toArray();
        for (int i : a){
            System.out.println(i);
        }

        //
        System.out.println("====");
        ArrayList<int[]> arr2 = new ArrayList<>();
        arr2.add(new int[]{1,2,3});
        arr2.add(new int[]{4,5,6});
        arr2.add(new int[]{7,8,9});
        int[][] b = arr2.toArray(new int[arr2.size()][]);
        for (int[] i : b){
            Arrays.stream(i).forEach(System.out::print);
            System.out.println();
        }
        //


        System.out.println("=============");
        char[][] charArr = new char[][]{{'1','1','1'},{'2','2','2'}};
        System.out.println(charArr.length);
        System.out.println(charArr[0].length);

    }
}
