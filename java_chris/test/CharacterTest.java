package test;

import java.util.Arrays;

public class CharacterTest {


    public static void main(String[] args) {
        Character chard = 'd';
        int c_int = Integer.valueOf(chard);
        System.out.println(c_int);


        char[][] test = new char[3][3];
        for (int i = 0 ; i < test.length ; i++) {
            for (int j = 0 ; j < test[i].length ; j++) {
                test[i][j] = 'a';
            }
        }

        Arrays.stream(test).forEach(System.out::println);

        String word = "word";
        Character negative = (char)-word.charAt(1);
        System.out.println(negative);
        negative = (char)-negative;
        System.out.println(negative);
    }


}
