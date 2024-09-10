package recursion;

public class FibonacciNumber_509 {

    //iteration
    public int fib(int n) {
        if (n <= 1){
            return n;
        }

        int a = 0;
        int b = 1;

        for (int i = 2; i < n+1 ; i++){
            int temp = b;
            b = a + b;
            a = temp;
        }
        return b;
    }

    //recursion
    public int fib2(int n) {
        if (n==0) {
            return 0;
        } else if (n==1) {
            return 1;
        } else {
            return fib2(n-1) + fib2(n-2);
        }
    }
}
