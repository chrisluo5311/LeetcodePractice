package array;

import java.util.HashSet;

/**
 * @author chris
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        HashSet<String> seen = new HashSet();

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9;j++){
                char curVal = board[i][j];
                //curVal不是.的時候才執行
                if (curVal != '.'){
                    //利用HashSet add重複值會回傳false的特性，如果回傳false就代表重複了，直接return false
                    if (!seen.add(curVal + "in row" + i)||
                        !seen.add(curVal + "in col" + j)||
                        !seen.add(curVal + "in sub box" + (i/3) + "-"+ (j/3))){
                        return false;
                    }
                }

            }
        }
        return true;
    }


}
