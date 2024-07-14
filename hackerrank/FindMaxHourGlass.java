import java.util.*;

public class FindMaxHourGlass {

    public static void main(String[] args) {
        List<List<Integer>> arr = Arrays.asList(
                Arrays.asList(-1,-1,0,-9,-2,-2),
                Arrays.asList(-2,-1,-6,-8,-2,-5),
                Arrays.asList(-1,-1,-1,-2,-3,-4),
                Arrays.asList(-1,-9,-2,-4,-4,-5),
                Arrays.asList(-7,-3,-3,-2,-9,-9),
                Arrays.asList(-1,-3,-1,-2,-4,-5));

        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.size()-2 ; i++){
            for (int j = 0 ; j < arr.get(i).size()-2 ; j++){
                int row1 = arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2);
                int row2 = arr.get(i+1).get(j+1);
                int row3 = arr.get(i+2).get(j) + arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2);
                sum = Math.max(sum, (row1+row2+row3));
            }
        }
        System.out.println(sum);
    }

}
