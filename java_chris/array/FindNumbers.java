package array;

public class FindNumbers {
    public static void main(String[] args) {
        int[] nums = new int[]{12,345,2,6,7896};
        int trackDigits = 0;
        int index = 0;
        for (int i : nums){
            while (i>0){
                trackDigits++;
                i /= 10;
            }
            nums[index] = trackDigits;
            index++;
            trackDigits = 0;
        }

        int result = 0;
        for (int i : nums){
            if (i % 2==0){
                result++;
            }
        }
        System.out.println(result);
    }
}
