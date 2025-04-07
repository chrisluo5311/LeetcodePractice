package dynamic_programming;

import java.util.Arrays;

public class Distinct_Subsequences_115 {
    static int[][] memo;
    public static int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        memo = new int[n][m];
        for (int[] row : memo){
            Arrays.fill(row, -1);
        }
        return backtrack(s, 0, t, 0);

    }

    static int backtrack(String s, int s_start, String t, int t_start) {
        if (t_start >= t.length()) {
            return 1;
        }

        if (s.length() - s_start < t.length() - t_start) {
            return 0;
        }

        if (memo[s_start][t_start] != -1) {
            return memo[s_start][t_start];
        }

        int res = 0;
        if (s.charAt(s_start) == t.charAt(t_start)) {
            res += backtrack(s, s_start+1, t, t_start+1) + backtrack(s, s_start+1, t, t_start);
        } else {
            res += backtrack(s, s_start+1, t, t_start);
        }


        memo[s_start][t_start] = res;
        return res;
    }

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println("There are " + numDistinct(s, t) + " ways you can generate 'rabbit' from s");
    }
}
