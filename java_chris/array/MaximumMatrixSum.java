package array;

public class MaximumMatrixSum {
    public static long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int negCnt = 0;
        int smallestNum = Integer.MAX_VALUE;
        for (int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0 ; j < matrix[0].length ; j++) {
                int curr = matrix[i][j];
                int absNum = Math.abs(curr);
                sum += (long) absNum;
                if (curr < 0) {
                    negCnt += 1;
                }

                if (absNum < smallestNum) {
                    smallestNum = absNum;
                }
            }
        }

        if (negCnt % 2 != 0) {
            // odd negatives
            sum -= Math.abs(smallestNum) * 2;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {-1, 0, -1},
                {-2, 1, 3},
                {3, 2, 2}
        };
        long res = maxMatrixSum(matrix);
        System.out.printf("%d\n", res); // 15

        int[][] matrix2 = {
                {2, 9, 3},
                {5, 4, -4},
                {1, 7, 1}
        };
        long res2 = maxMatrixSum(matrix2);
        System.out.printf("%d\n", res2); // 34
    }
}
