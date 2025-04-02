package test;

public class recursion {

    public static void _helper(int i) {
        if (i == 3) return;
        System.out.println(i);
        _helper(i+1);
        System.out.println("After: " + i);
    }

    public static void main(String[] args) {
        _helper(0);
    }
}
