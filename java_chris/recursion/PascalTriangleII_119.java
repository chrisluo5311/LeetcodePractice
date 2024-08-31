package recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII_119 {
    public static void main(String[] args) {
        List<Integer> ans = getRow(3);
        ans.forEach(System.out::println);
    }

    //brute force will lead to time limits exceed
    private static int getNum(int row, int col){
        if (row == 0 || col == 0 || row == col) {
            return 1;
        }
        return getNum(row-1,col-1) + getNum(row-1,col);
    }

    public static List<Integer> getRow(int rowIndex){
        List<Integer> ans = new ArrayList<Integer>();
        //brute force
//        for (int i = 0 ; i <= rowIndex ; i++) {
//            ans.add(getNum(rowIndex,i));
//        }
        //
        return ans;
    }
}
