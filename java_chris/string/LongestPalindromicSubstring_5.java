package string;

public class LongestPalindromicSubstring_5 {
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        String ans = "";
        for (int i = 0 ; i+1 < s.length() ; i++) {
            // odd: aba
            String sub1 = paindrome(s, i, i);
            // even: bb
            String sub2 = paindrome(s, i, i+1);

            // track the longest
            ans = ans.length() > sub1.length() ? ans : sub1;
            ans = ans.length() > sub2.length() ? ans : sub2;
        }

        return ans;
    }

    String paindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() &&
                s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring_5 lps = new LongestPalindromicSubstring_5();
        String s = "babad";
        String ans = lps.longestPalindrome(s);
        System.out.println(ans);

        System.out.println("==================================");

        String s2 = "cbbd";
        String ans2 = lps.longestPalindrome(s2);
        System.out.println(ans2);

    }
}
