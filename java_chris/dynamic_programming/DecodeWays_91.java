package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays_91 {

    static Map<Integer,Integer> memo = new HashMap<>();

    public static int numDecodings(String s) {
        return recursive(s, 0);
    }

    private static int recursive(String s, int index) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        if (index == s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        if (index == s.length() - 1) {
            return 1;
        }

        int ans = recursive(s, index + 1);
        if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            ans += recursive(s, index + 2);
        }

        memo.put(index, ans);
        return ans;
    }

    public static void main(String[] args) {
        int ans = numDecodings("2326");
        System.out.println(ans);
    }
}
