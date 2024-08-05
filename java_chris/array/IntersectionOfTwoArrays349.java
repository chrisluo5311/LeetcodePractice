package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two integer arrays nums1 and nums2, return an array of their
 * intersection
 * . Each element in the result must be unique and you may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * */
public class IntersectionOfTwoArrays349 {
    public static void main(String[] args) {

    }

    private static int[] approach1_sortingAndTwoPointers(int[] nums1, int[] nums2){
        // sort the array
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int N = nums1.length;
        int M = nums2.length;
        int p1 = 0;
        int p2 = 0;

        // create set that stores integers appearing in both arrays
        Set<Integer> intersection = new HashSet<>();

        // Iterate the pointers from left to right
        while (p1 < N && p2 < M) {
            // add a value to set if values at both pointers equal
            if (nums1[p1] == nums2[p2]) {
                intersection.add(nums1[p1]);
                p1++;
                p2++;
            }

            // otherwise, increase the pointer of the smaller integer
            else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        // set to array
        int k = intersection.size();
        int[] result = new int[k];
        int curr = 0;
        for (int i : intersection){
            result[curr++] = i;
        }

        return result;
    }

    private static int[] approach2_retainAll(int[] nums1, int[] nums2){
        Set<Integer> set1 = new HashSet<>();
        for (Integer n : nums1){
            set1.add(n);
        }

        Set<Integer> set2 = new HashSet<>();
        for (Integer n : nums2){
            set2.add(n);
        }

        set1.retainAll(set2);
        int[] output = new int[set1.size()];
        int curr = 0;
        for (int i : set1){
            output[curr++] = i;
        }
        return output;
    }

    private static int[] approach3_setIntersection(int[] nums1, int[] nums2){
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1){
            set1.add(i);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2){
            set2.add(i);
        }

        if (set1.size() < set2.size()){
            return setIntersection(set1,set2);
        } else {
            return setIntersection(set2,set1);
        }
    }
    private static int[] setIntersection(Set<Integer> set1, Set<Integer> set2) {
        int[] result = new int[set1.size()];
        int curr = 0;
        for (Integer i : set1) {
            if (set2.contains(i)){
                result[curr++] = i;
            }
        }
        return Arrays.copyOf(result, curr);
    }


}
