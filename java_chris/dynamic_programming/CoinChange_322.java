package dynamic_programming;

import java.util.Arrays;

public class CoinChange_322 {
    int[] memo;
    public static int coinChange(int[] coins, int amount) {
        // 题目要求的最终结果是 dp(amount)
        return dp(coins, amount);
    }

    public int coinChange_dp(int[] coins, int amount){
        memo = new int[amount+1];
        Arrays.fill(memo,-666);
        return dp_memo(coins,amount);
    }

    public static int dp(int[] coins, int amount) {
        // base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1) continue;
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    // 定义：要凑出金额 n，至少要 dp(coins, n) 个硬币
    public int dp_memo(int[] coins, int amount) {
        // base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (memo[amount] != -666){
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp_memo(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1) continue;
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }
        memo[amount] = (res  == Integer.MAX_VALUE) ? -1 : res;
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int dp_iterative(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);

        dp[0] = 0;
        for (int i = 0; i< dp.length ; i++){
            for (int coin : coins){
                if (i - coin < 0){
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        return (dp[amount] == amount+1) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount = 5;

//        int result = coinChange(new int[]{1,2,5},5);
//        System.out.println(result);
        CoinChange_322 coin = new CoinChange_322();
        int result2 = coin.coinChange_dp(coins,amount);
        System.out.println("dp_memo result: "+result2);

        int result3 = coin.dp_iterative(coins,amount);
        System.out.println("dp_iterative result: "+result3);
    }
}
