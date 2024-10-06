package dynamic_programming;

import java.util.Arrays;
import java.util.List;

public class WordBreak_139 {
    int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length()+1];
        Arrays.fill(memo,-1);
        return dp(s, 0, wordDict);
    }

    boolean dp(String s, int i, List<String> wordDict) {
        if (i == s.length()) return true;
        if (memo[i] != -1) {
            return (memo[i] == 1) ? true : false;
        }
        for (String word : wordDict) {
            int len = word.length();
            if (i + len > s.length()) continue;
            String subStr = s.substring(i, i + len);
            if (!word.equals(subStr)) {
                continue;
            }
            if (dp(s,i + len, wordDict)) {
                memo[i] = 1;
                return true;
            }
        }
        memo[i] = 0;
        return false;
    }
}
