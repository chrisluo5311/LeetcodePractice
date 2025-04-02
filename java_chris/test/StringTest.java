package test;

import java.util.Arrays;
import java.util.HashMap;

public class StringTest {
    public static void main(String[] args) {
        String s1 = "hello";
        System.out.println(s1.length());
//        Character i = ')';
//        String bracket = String.valueOf(i);
//        System.out.println(bracket);

        String test = "eat";
        char[] arr = test.toCharArray();
        Arrays.sort(arr);
        String s2 = new String(arr);
        System.out.println(s2);


        char[][] board = new char[3][3];
        for (int i = 0 ; i < board.length ; i++) {
            for (int j = 0 ; j < board[i].length ; j++) {
                board[i][j] = '*';
            }
        }

        for (int i = 0 ; i < board.length ; i++) {
            String cur_row = String.valueOf(board[i]);
            System.out.println(cur_row);
        }
    }
}
