package USC570_HighestPossibleScore;
/*
* 如果题目要求中增加一个上限W 那么这个题就会变成一个不可重复选的背包问题
*
* 注意 如果想做题目i 那么题目i - 1 到 题目i - wi都不能做 这种想法是错误的
* 所以 如果正着做的话 可能需要去遍历之前的所有j 找到j满足j + wj < i 而且 dp[j] + pi最大
* */
public class Solution2 {
    public int highestPossibleScore(int n, int[] p, int[] w) {
        int[] dp = new int[n + 1];

        /* base case */
        dp[0] = 0;
        dp[1] = p[0];
        for (int i = 2; i <= n ; i ++) {
            for (int j = i - 1; j >= 1; j --) {
                if (j + w[j - 1] < i) {
                    dp[i] = Math.max(dp[i], dp[j] + p[i - 1]);
                }
            }
        }
        return dp[n];
    }
}
