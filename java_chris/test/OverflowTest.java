package test;

public class OverflowTest {
    public static void main(String[] args) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        int mid = (left + right) / 2;  // 這裡可能會溢位

    }
}
