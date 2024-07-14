import java.util.stream.Stream;

public class MergeSortedArray {
    public static void main(String[] args) {
        //int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums1 = {4, 0, 0, 0, 0, 0};
        int m = 1;
        //int[] nums2 = {2, 5, 6};
        int[] nums2 = {1,2,3,5,6};
        int n = 5;

        if (n == 0) {
            System.out.println("n is zero");
        }
        if (m == 0){
            for (int i = 0; i < nums1.length;i++){
                nums1[i] = nums2[i];
            }
        }
        int hi1 = n-1; //4
        int hi2 = m-1; //0
        for (int i = m + n -1 ; i >= 0 ; i--){
            if (hi1 >= 0 && hi2 >= 0){
                nums1[i] = nums2[hi1] > nums1[hi2] ? nums2[hi1--] : nums1[hi2--];
            } else if (hi2 >= 0) {
                nums1[i] = nums1[hi2--];
            } else {
                nums1[i] = nums2[hi1--];
            }
        }

        for (int n1 : nums1){
            System.out.print(n1 + " ");
        }
    }
}
