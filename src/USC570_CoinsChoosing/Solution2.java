package USC570_CoinsChoosing;

/**
 * 行列交换
 */
public class Solution2 {
    public int coins(int m, int[] d) {
        int len = d.length;
        int[][] dp = new int[m + 1][len];

        /* base case */
        for(int j = 0; j < len; j ++) { // 待组成金额为0
            dp[0][j] = 0;
        }

        for (int i = 0; i < m + 1; i ++) { //硬币面值为1
            dp[i][0] = i;
        }

        /* dp */
        for (int i = 1; i < m + 1; i ++) {
            for (int j = 1; j < len; j ++) {
                if (d[j] > i) {
                    dp[i][j] = dp[i][j - 1];
                    continue;
                }
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - d[j]][j - 1] + 1);
            }
        }

        return dp[m][len - 1];
    }
}
