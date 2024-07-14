package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKClosestElement {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int l = 0;
        int r = arr.length - k;

        while (l < r) {
            int mid = l + (r - l)/2;
            if (x < arr[mid]) {
                r = mid;
            } else if (x > arr[mid+k]) {
                l = mid + 1;
            } else {
                if (x - arr[mid] <= arr[mid + k] -x){
                    r = mid;
                } else {
                    l = mid;
                }
            }
        }

        for (int i = l; i < l+k ; i++){
            ans.add(arr[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] arr2 = {1,1,1,10,10,10};
        int k = 1;
        int x = 9;
        List<Integer> ans = findClosestElements(arr2,k,x);
        ans.stream().forEach(System.out::println);
    }
}
