package test;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<int[]> queue = new LinkedList<>();
        int[] test = new int[2];
        test[0] = 1;
        test[1] = 2;
        queue.add(test);
        System.out.println();
    }
}
