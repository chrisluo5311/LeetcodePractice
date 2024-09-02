package hashmap;
import java.util.HashMap;
public class ContainsDuplicate_217 {
    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> output = new HashMap<>();

        for (int i : nums){
            if (output.containsKey(i)){
                return true;
            } else {
                output.put(i,1);
            }

        }
        return false;
    }

    public static void main(String[] args) {
        boolean output = containsDuplicate(new int[]{1, 2, 3, 1, 5});
        System.out.println(output);
    }

}
