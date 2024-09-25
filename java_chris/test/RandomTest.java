package test;

import java.util.Random;

public class RandomTest {

    public static void main(String[] args) {
        Random random = new Random();

        // nextInt(upperBond): generate numbers from [0 - (upperBond-1)]
        for (int i = 0; i < 10; i++) {
            int a = random.nextInt(10);
            System.out.print(a+",");
        }


    }
}
