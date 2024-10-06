package dynamic_programming;

public class Fibonacci {

    public static int fib(int n) {
        int[] memo = new int[n + 1];
        return dp(n,memo);
    }

    public static int dp(int n, int[] memo) {
        if (n == 0 || n == 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = dp(n - 1, memo) + dp(n - 2, memo);
        return memo[n];
    }

    public static int dp_bottomUp(int n){
        if (n < 2) return n;
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++){
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }

    public static int dp_bottomUp_Enhanced(int n){
        if (n < 2) return n;
        int dp_i_1 = 1;
        int dp_i_2 = 0;
        for (int i = 2; i <= n; i++){
            int dp_i = dp_i_1 + dp_i_2;
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i_1;
    }

    public static void main(String[] args) {
        int n = 10;
        int result = fib(n);
        System.out.println("Top Down Method:");
        System.out.println("fib: " + n + " ,result: " + result);

        System.out.println("Bottom Up Method:");
        int result2 = dp_bottomUp(n);
        System.out.println("fib: " + n + " ,result: " + result2);

        System.out.println("Bottom Up Enhanced Method:");
        int result3 = dp_bottomUp_Enhanced(n);
        System.out.println("fib: " + n + " ,result: " + result3);
    }
}
