package test;

import java.util.Arrays;

public class MathTest {
    public static void main(String[] args) {
        System.out.println((int)Math.pow(2,3));

        System.out.println(Math.max(-1,-2));

        int[] result = new int[]{1,2,3,2,5};
        System.out.println(Arrays.toString(result));

        int a = (int) (4321 / Math.pow(10,3));
        System.out.println(a);


    }
}
