package array;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 0;
        for (int i = n-1; i >= 0 ; i--){
            if (carry > 0) {
                digits[i] += carry;
            } else {
                digits[i]++;
            }
            if (digits[i] > 9){
                digits[i] = 0;
                carry = 1;
                continue;
            } else {
                return digits;
            }
        }
        if (carry > 0) {
            int[] output = new int[n+1];
            output[0] = carry;
            for (int i =1 ; i < n+1;i++){
                output[i] = digits[i-1];
            }
            return output;
        } else {
            return digits;
        }
    }

    public static void main(String[] args) {
        int[] digits = {8,9,9,9};
        int[] output = plusOne(digits);
        for (int i : output) {
            System.out.print(i + " ");
        }
    }
}
