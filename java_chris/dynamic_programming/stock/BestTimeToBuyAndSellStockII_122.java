package dynamic_programming.stock;

/**
 *
 *  k = infinity in this problem
 *
 * */
public class BestTimeToBuyAndSellStockII_122 {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0 ; i < n ; i++) {
            if (i-1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            // no stock: max(reset, sell stock)
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            // own stock: max(reset, buy stock)
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int maxProfit = maxProfit(prices);
        System.out.printf("The max profit is %d", maxProfit);
    }
}
