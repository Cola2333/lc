package USC570_KnapsackProblem;

/**
 * 行列交换 会得到一个weight * n / 2 大小的表
 */
public class Solution2 {
    int knapsack(int weight, int[] w, int[] v, int n) {
        int[][] dp = new int[weight + 1][n + 1];

        /* base case 是0 直接省略*/

        /* dp */
        for (int i = 1; i < weight + 1; i ++) { // 背包重量
            for (int j = 1; j < n + 1; j ++) { // 待选货物
                if (w[j] > i) {
                    dp[i][j] = dp[i][j - 1];
                    continue;
                }
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - w[j]][j - 1] + v[j]);
            }
        }

        return dp[weight + 1][n + 1];
    }
}
