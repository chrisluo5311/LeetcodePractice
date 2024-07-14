package array;

public class ValidMountainArray {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        //two pointers
        if (arr.length < 3) {
            System.out.println("false");
        }
        int l = 0;
        //arr.length - 1 就是最後一個元素的指針
        int r = arr.length-1;
        while(l+1 < arr.length-1 && arr[l] < arr[l+1]) {
            l++;
        }
        while(r-1 > 0 && arr[r] < arr[r-1]) {
            r--;
        }
        System.out.println(l==r);
        // TC : O(n)
        // SC : O(1)
    }
}
