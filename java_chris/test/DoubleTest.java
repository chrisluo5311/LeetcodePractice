package test;

public class DoubleTest {
    public static void main(String[] args) {
        long subTotal = 3;
        int size = 2;
        subTotal += 5;
        Double result = (double)subTotal / size;
        System.out.println(result);
        System.out.println(result.getClass().getName());
    }
}
