package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TikTok is working to make the process of creating unique video IDs more efficient.
 * A TikTok video ID is represented as a string called idStream of length n, made up of the digits 0-9.
 * TikTok also has a list called videoIds, which contains m target video ID strings, each also made up of digits 0-9.
 * For each target video ID in videoIds. find the shortest part of idStream that contains all the characters needed to
 * form any possible arrangement (permutation) of the target string.
 * You need to return an array of integers. The number at each position i in this array should be the length of the
 * shortest part of idStream that can include all characters of the string in videos.
 * If it's impossible to create the target video ID from idStream, return -1 for that position.
 * 样例
 * idStream= "064819848398"
 * videos =["088", "364", "07"]
 * 输出
 * [7, 10, -1]
 * To construct "088", the first 7 characters of the idStream ("064819848398") contain "0" "8" "8".
 * Therefore, the answer for this target is 7.
 * To construct "364", we need to access the first 10 characters of the idStream ("064819848398") and
 * use the digits '6', '4', and '3'. By rearranging these digits to match "364". the answer is 10.
 * For "07", there is no prefix in the idStream that contains both "0" and "7".
 * */
public class TikTok1 {
    public static List<Integer> minWindow(String s, String[] t) {
        List<Integer> ans = new ArrayList<>();
        for (String target : t) {
            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();
            for (char c : target.toCharArray()){
                need.put(c,need.getOrDefault(c,0)+1);
            }

            int n = s.length();
            int left = 0;
            int right = 0;
            int len = Integer.MAX_VALUE;
            int valid = 0;
            while (right < n) {
                Character right_D = s.charAt(right);
                right++;
                if (need.containsKey(right_D)){
                    window.put(right_D, window.getOrDefault(right_D,0)+1);
                    if (window.get(right_D).equals(need.get(right_D))){
                        valid++;
                    }
                }

                while (valid == need.size()){
                    if (right - left < len) {
                        len = right - left;
                    }
                    Character left_D = s.charAt(left);
                    left++;
                    if (need.containsKey(left_D)){
                        if (window.get(left_D).equals(need.get(left_D))){
                            valid--;
                        }
                        window.put(left_D, window.get(left_D)-1);
                    }
                }
            }
            ans.add((len == Integer.MAX_VALUE) ? -1 : len );
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "064819848398";
        String[] t = {"088", "364", "07"};
        List<Integer> ans = minWindow(s,t);
        ans.forEach(System.out::println);
    }
}
