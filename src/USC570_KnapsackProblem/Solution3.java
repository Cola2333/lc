package USC570_KnapsackProblem;

/**
 * 降维解法 只保留上一行数据
 * 也就是说 实际解法维solution1，但是采取降维
 */
public class Solution3 {
    int knapsack(int weight, int[] w, int[] v, int n) {
        int[] dp = new int[n + 1];

        for(int i = 1; i < n + 1; i ++) { // 待选货物
            for(int j = 1; j < weight + 1; j ++) { // 背包重量
                if (w[i] > j) {
                    continue;
                }
                dp[j] = Math.max(dp[j - w[i]] + v[i], dp[j]); // 作出选择
            }
        }

        return dp[weight + 1];
    }
}
