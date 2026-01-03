package dynamic_programming;

public class NumberOfWaysToPainN3Grid {

    public static int numOfWays(int n) {
        // aba -> bab, bcb, cac/ bac, cab
        // abc -> bab, bcb/ bca, cab
        // a[i] = 3*a[i]+2*b[i]
        // b[i] = 2*a[i]+2*b[i]

        long mod = 1000000007;

        long a = 6;
        long b = 6;
        for (int i = 1; i < n; i++) {
            long newA = (3*a + 2*b)%mod;
            long newB = (2*a + 2*b)%mod;
            a = newA;
            b = newB;
        }

        return (int)((a+b)%mod);
    }

    public static void main(String[] args) {
        int res = numOfWays(1);
        System.out.printf("%d\n", res); // 12
        int res2 = numOfWays(2);
        System.out.printf("%d\n", res2); // 54
        int res3 = numOfWays(5000);
        System.out.printf("%d\n", res3); // 30228214
    }
}
