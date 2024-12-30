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


        // 判別是不是字母
        System.out.println("=================================");
        char isLetter_1 = 'A';
        isLetter_1 = String.valueOf(isLetter_1).toLowerCase().toCharArray()[0];
        System.out.println(isLetter_1);
        char isLetter_2 = 'z';
        int x = isLetter_1 - 'a';
        System.out.println(x);
        int y = isLetter_2 - 'a';
        System.out.println(y);

        System.out.println("====");
        char isNumber_1 = '1';
        char isNumber_2 = '2';
        int z = isNumber_1 - '0';
        System.out.println(z);
        int z2 = isNumber_2 - '0';
        System.out.println(z2);

        System.out.println("===");
        char rand = ',';
        int r = rand - '0';
        System.out.println(r);

        StringBuilder s = new StringBuilder();
        s.append('a');
        System.out.println(s.toString());


    }

}
