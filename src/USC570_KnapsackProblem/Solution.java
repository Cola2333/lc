package USC570_KnapsackProblem;
/**
 * 最常规解法 会得到一个n * weight 大小的表
 */
public class Solution {
    /**
     *
     * @param weight 背包重量上限
     * @param w 商品重量数组
     * @param v 商品价值数组
     * @param n 待选择的商品数
     * @return
     */
    int knapsack(int weight, int[] w, int[] v, int n) {

        int[][] dp = new int[n + 1][weight + 1];

        /* base case 可以不写*/
        for (int j = 0; j < weight + 1; j ++) { // 无货物可选 必然为0
            dp[0][j] = 0;
        }

        for (int i = 0; i < n + 1; i ++) { // 无重量放货物 必然为0
            dp[i][0] = 0;
        }

        /* dp */
        for (int i = 1; i < n + 1; i++) { // 选择货物
            for(int j = 1; j < weight + 1; j ++) { // 背包重量
                if (w[i] > j) { // 货物重量大于背包重量 肯定无法选择
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]); // 做选择
            }

        }

        return dp[n][weight];





    }
}
