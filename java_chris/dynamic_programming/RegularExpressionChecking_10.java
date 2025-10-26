package dynamic_programming;

enum Result{
    TRUE,
    FALSE
}

public class RegularExpressionChecking_10 {
    Result[][] cache;
    public boolean isMatch(String s, String p) {
        cache = new Result[s.length() + 1][p.length() +1];
        return dfs(0, 0, s, p);
    }

    public boolean dfs(int i, int j, String s, String p){
        // check caching
        if (cache[i][j] != null) {
            return cache[i][j] == Result.TRUE;
        }

        // match patter to the string -> true
        if (i >= s.length() && j >= p.length()) {
            return true;
        }

        // out of pattern to match -> false
        if (j >= p.length()) {
            return false;
        }

        // "a" -> "a" or "a" -> "."
        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        // check if the next char is *
        if (j+1 < p.length() && p.charAt(j+1) == '*') {
            // use * -> i + 1
            // don't use * -> j + 2
            boolean temp = (match && dfs(i+1, j, s, p)) || dfs(i, j+2, s, p);
            cache[i][j] = temp ? Result.TRUE : Result.FALSE;
            return cache[i][j] == Result.TRUE;
        }

        // no * -> regular check match
        if (match) {
            boolean temp = dfs(i+1, j+1, s, p);
            cache[i][j] = temp ? Result.TRUE : Result.FALSE;
            return cache[i][j] == Result.TRUE;
        }

        // don't match -> false
        cache[i][j] = Result.FALSE;
        return false;
    }


    public static void main(String[] args) {
        RegularExpressionChecking_10 re = new RegularExpressionChecking_10();
        System.out.println(re.isMatch("ab", ".*"));
    }
}
