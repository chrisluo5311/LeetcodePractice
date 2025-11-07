package array;

import java.util.Arrays;

public class H_Index_274 {
    public int hIndex(int[] citations) {
        int c_len = citations.length;
        Arrays.sort(citations);// 0,1,3,5,6
        int i = 0;
        while (i < c_len && citations[c_len - 1 - i] > i) {
            i++;
        }
        return i;
    }
}
