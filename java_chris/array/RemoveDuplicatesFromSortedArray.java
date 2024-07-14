package array;

/**
 * @author chris
 */
public class RemoveDuplicatesFromSortedArray {


    public static int removeDuplicates(int[] nums) {
        int insertIndex = 1;
        for (int i = 1; i<nums.length;++i){
            if (nums[i] != nums[i-1]){
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        return insertIndex;
    }

    public static int removeDuplicates2(int[] nums) {

            // The initial length is simply the capacity.
            int length = nums.length;

            // Assume the last element is always unique.
            // Then for each element, delete it if it is
            // the same as the one after it. Use our deletion
            // algorithm for deleting from any index.
            for (int i = length - 2; i >= 0; i--) {
                if (nums[i] == nums[i + 1]) {
                    // Delete the element at index i, using our standard
                    // deletion algorithm we learned.
                    for (int j = i + 1; j < length; j++) {
                        nums[j - 1] = nums[j];
                    }
                    // Reduce the length by 1.
                    length--;
                }
            }
            // Return the new length.
            return length;

    }

    public static void main(String[] args) {
//        int insertIndex = removeDuplicates(new int[]{1,1,2,2,3,3,4});
//        System.out.println(insertIndex);
        int length = removeDuplicates2(new int[]{1,1,2,3,3,4});
        System.out.println(length);

    }


}
