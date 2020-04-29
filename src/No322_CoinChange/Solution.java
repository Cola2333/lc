package No322_CoinChange;

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int len = coins.length;
        if (len == 0)
            return -1;

        int[][] dp = new int[len + 1][amount + 1]; //硬币数从0到len 金钱数从0到amount

        /* base case */
        for (int j = 0; j <= amount; j ++) { //不选硬币 无法组成
            dp[0][j] = amount + 1; //amount+1表示无法组成 因为如果可以组成的话硬币数不会超过amount 因为之后要用Math.min所以这不能用-1
        }
/*        for (int i = 0; i < len + 1; i ++) { //amount为零 显然不需要选
            dp[i][0] = 0;
        }*/

        /* dp */
        for(int i = 1; i < len + 1; i ++) {
            for (int j = 1; j <= amount; j ++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.min(dp[i][j - coins[i - 1]] + 1, dp[i - 1][j]);
            }
        }
        return dp[len][amount] == amount + 1 ? -1 : dp[len][amount];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] coins = new int[] {2};
        int amount = 3;
        int res = s.coinChange(coins, amount);
        System.out.print(res);

    }
}
