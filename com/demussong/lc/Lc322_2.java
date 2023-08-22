package com.demussong.lc;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/3/8 23:15
 */
public class Lc322_2 {

    public static void main(String[] args) {
        int[] coins = new int[]{2,5};

        coinChange(coins, 11);
    }
    public static void coinChange(int[] coins, int amount) {
//        if (amount == 0) {
//            return -1;
//        }
        // f[i][j] = Math.min(f[i - 1][j], f[i][j-w[i]] + v[i])
        boolean[][] dp = new boolean[coins.length + 1][amount + 1];
        dp[0][0] = true;
        for (int i = 1;i <= coins.length;i++) {
            for (int j = 0; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i -1][j] || dp[i][j - coins[i-1]];

                }
            }
        }
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
