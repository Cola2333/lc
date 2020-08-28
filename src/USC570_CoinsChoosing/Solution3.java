package USC570_CoinsChoosing;

/**
 * 降维 但是思路与不可重复背包问题的降维思路不同
 * 可重复背包问题无法采用不可重复背包问题的降维思路，因为所需要的数据不一定只来源与上一行，也可能来源于当前行的之前列
 */
public class Solution3 {
    public int coins(int m, int[] d) {
        int len = d.length;
        int[] dp = new int[m + 1];

        /* base case 待组成金额为0 */
        dp[0] = 0;

        /* dp */
        for (int i = 1; i < m + 1; i ++) { // 待组成金额
            for (int j = 0; j < len; j ++) { // 硬币面额
                if (d[j] > i) { // 硬币面额大于代组成的面额
                    continue;
                }
                dp[i] = Math.min(dp[i - d[j]] + 1, dp[i]); //决策 选取当前硬币，剪掉当前硬币面额得到已经决策过的dp，拿到最优
            }
        }

        return dp[m + 1];
    }
}
