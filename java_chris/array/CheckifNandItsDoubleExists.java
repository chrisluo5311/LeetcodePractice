package array;

import java.util.HashMap;
import java.util.Map;

public class CheckifNandItsDoubleExists {
    public static void main(String[] args) {
        int arr[] = new int[]{10,2,5,3};
        Map<Integer,Integer> visited = new HashMap<>();
        for (int i = 0; i < arr.length;i++){
            visited.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++){
            if (visited.containsKey(arr[i]*2)&&
                    visited.get(arr[i]*2)!=i){
                System.out.println("true");
                return;
            }
        }
        System.out.println("false");
        // TC : O(n) + O(n*n) = O(n^2)
        // SC : O(n)
    }
}
