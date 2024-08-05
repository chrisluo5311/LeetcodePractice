package binarysearch;

public class MedianOfTwoSortedArrays_4 {
    public static void main(String[] args) {
        double result = findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4});
        System.out.println(result);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2,nums1);
        }

        // len
        int n1 = nums1.length;
        int n2 = nums2.length;

        int totalLength = n1 + n2;
        int target = (totalLength + 1)/2;

        // index
        int lo = 0;
        int hi = n1;
        while (true) {
            int take1 = lo + (hi - lo)/2;
            int take2 = target - take1;

            // compare
            int max1 = (take1 == 0)? Integer.MIN_VALUE : nums1[take1-1];
            int min1 = (take1 == n1)? Integer.MAX_VALUE : nums1[take1];
            int max2 = (take2 == 0)? Integer.MIN_VALUE : nums2[take2-1];
            int min2 = (take2 == n2)? Integer.MAX_VALUE : nums2[take2];

            if (max1 > min2) {
                hi = take1 - 1;
                continue;
            }

            if (max2 > min1) {
                lo = take1 + 1;
                continue;
            }

            // Target found
            int medianMaxOdd = Math.max(max1,max2);
            if (totalLength % 2 == 0) {
                return (medianMaxOdd + Math.min(min1,min2))/2.0;
            } else {
                return medianMaxOdd;
            }
        }

    }
}
