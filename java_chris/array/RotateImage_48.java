package array;

public class RotateImage_48 {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        // diagonal
        for (int i = 0; i < row ; i++) {
            for (int j = i ; j < column ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // left, right reverse
        int middleColIndex = column / 2;
        for (int i = 0 ; i < row; i++){
            for (int j = 0; j < middleColIndex ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][column - 1 - j];
                matrix[i][column - 1 - j] = temp;
            }
        }
    }
}
