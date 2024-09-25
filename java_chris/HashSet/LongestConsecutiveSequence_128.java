package hashset;

import java.util.HashSet;

public class LongestConsecutiveSequence_128 {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums){
            set.add(i);
        }

        int seq = 0;
        for (int i : set) {
            if (set.contains(i-1)){
                continue;
            }
            int tmpIndex = i+1;
            int tmpCount = 1;
            while(set.contains(tmpIndex)) {
                tmpCount++;
                tmpIndex++;
            }
            seq = Math.max(seq, tmpCount);
        }
        return seq;
    }

}
