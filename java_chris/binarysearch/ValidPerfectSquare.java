package binarysearch;

public class ValidPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        //num = 14
        int start = 1;
        int end = num/2; // 7
        while (start <= end) {
            int mid = start + (end-start)/2; //4
            double temp = (double)mid*mid; //4
            if (temp == (double)num) {
                return true;
            } else if (temp > (double)num){
                end = mid-1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean isPerfectSqr = isPerfectSquare(14);
        System.out.println(isPerfectSqr);
    }
}
