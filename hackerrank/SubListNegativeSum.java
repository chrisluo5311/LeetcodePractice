import java.util.Arrays;
import java.util.List;

public class SubListNegativeSum {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1,-2,4,-5,1);
//        System.out.println(arr.subList(0,2));
        int len = arr.size();
        int countNegSum = 0;
        for (int i = 1 ; i <= len ; i++){ // 查看几个组合
            for (int j = 0 ; j <= len-i ; j++){
                List<Integer> subList = arr.subList(j,j+i);
                int tempSum = subList.stream().reduce(0,Integer::sum);
                if (tempSum < 0) {
                    countNegSum++;
                }
            }
        }
        System.out.println(countNegSum);
    }
}
