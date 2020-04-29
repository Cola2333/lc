package No322_CoinChange;
/*
* 子问题 OPT[i]表示组成金额i需要的最小硬币数
*
* 注意 这种解法和背包的解法 base case是不同的
* 因为我们的思路是 当前amount的硬币数量肯定可以由 amount-coins[i] + 1得到n
* 因此 如果我们把dp[0]赋值为amount + 1 那么dp[i]都会在amount + 1上在进行+ 1 再取Min 也就是永远都是amount + 1
* 根据我们的思路 dp[0] = 0 意味组成金额0只需0个硬币
* 但是 我们无法知道当前金额是否可以由给定的硬币组成 所以dp[i]初始值为amount + 1 表示不能组成
* */
class Solution2 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        /* base case */
        dp[0] = 0; //不要写成dp[0] = amount + 1
//        dp[i] = amount + 1
        /* dp */
        for (int i = 1; i <= amount; i ++) {
            dp[i] = amount + 1; // 不要写成dp[i] = dp[i - 1]
            for (int j = 0; j < coins.length; j ++) {
                if (coins[j]> i) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
//        int[] coins = new int[] {2};
//        int amount = 3;

        int[] coins = new int[] {1, 2, 5};
        int amount = 11;
        int res = s.coinChange(coins, amount);
        System.out.print(res);

    }
}
