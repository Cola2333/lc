package USC570_CoinsChoosing;

/**
 * 最常规解法
 * 外层for为硬币面额
 */
public class Solution {
    /**
     *
     * @param m 要组成的金额数
     * @param d 硬币数组 记录硬币的面值
     * @return
     */
    public int coins(int m, int[] d) {
        int len = d.length;
        int[][] dp = new int[len][m + 1];

        /* base case */
        for (int j = 0; j < m + 1; j ++) { // dp[0]的面值为1 组成金额j自然需要j个
            dp[0][j] = j;
        }

        for (int i = 0; i < len; i ++) { // 要组成的面值为0
            dp[i][0] = 0;
        }

        /* dp */
        for (int i  = 1; i < len; i ++) { // 待选硬币
            for (int j = 1; j < m + 1; j ++) { // 要组成的金额
                if (d[i] > m) { // 当前硬币金额大于当前金额 无法选择
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - d[i]] + 1);
            }
        }

        return dp[len - 1][m];
    }

}
