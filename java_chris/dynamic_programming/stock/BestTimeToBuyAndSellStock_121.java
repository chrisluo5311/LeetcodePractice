package dynamic_programming.stock;

public class BestTimeToBuyAndSellStock_121 {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0 ; i < n ; i++) {
            if (i-1 < 0) {
                // no stock
                dp[i][0] = 0;
                // with stock
                dp[i][1] = -prices[i];
                continue;
            }
            // no holding stock: max(reset, buy)
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            // hold stock: max(reset, sell= ((dp[i-1][0][1]=0) - prices[i])
            dp[i][1] = Math.max(dp[i-1][1],  -prices[i]);

        }

        return dp[n-1][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int maxProfit = maxProfit(prices);
        System.out.printf("The max profit is %d", maxProfit);
    }
}
