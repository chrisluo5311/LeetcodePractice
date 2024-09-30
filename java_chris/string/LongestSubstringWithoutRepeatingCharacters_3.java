package string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int len = Integer.MIN_VALUE;
        while (right < s.length()){
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c,0) + 1);
            while (window.get(c) > 1){
                char d = s.charAt(left);
                left++;
                window.put(d,window.get(d)-1);
            }
            len = Math.max(len,right-left);
        }
        return len==Integer.MIN_VALUE ? 0 : len;
    }
}
