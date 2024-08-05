package test;

import java.util.*;

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


        int[] nums2 = new int[]{1,2,3,4,5,6,7};
        for (int i = 0; i<nums2.length/2; i++){
            int temp = nums2[i];
            nums2[i] = nums2[nums2.length-1-i];
            nums2[nums2.length-1-i] = temp;
        }
        for (int i : nums2){
            System.out.print(i);
        }

        Set<Integer> s = new HashSet<>();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(1);
        System.out.println("\n---------------------------");
        List<Integer> sArray = new ArrayList<>();
        sArray.addAll(s);
        System.out.println(sArray);
        System.out.println(sArray.contains(5));
        System.out.println(sArray.get(0));
    }
}
