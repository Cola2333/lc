package USC570_HighestPossibleScore;
/*
* 如果题目要求中增加一个上限W 那么这个题就会变成一个不可重复选的背包问题
*
* 注意 如果想做题目i 那么题目i - 1 到 题目i - wi都不能做 这种想法是错误的
* 所以 如果正着做的话 需要去遍历之前的所有j 找到j满足j + wj < i 而且 dp[j] + pi最大 或者不做第i题 dp[i - 1]
* 但是有一点需要注意 可能遍历之前所有的j都没有符合条件的 那么dp[i] = p[i - 1] 可以认为 dp[i]的最小也至少是 p[i - 1]和dp[i - 1]中较大的
*
* */
public class Solution2 {
    public int highestPossibleScore(int n, int[] p, int[] w) {
        int[] dp = new int[n + 1];

        /* base case */
        dp[0] = 0;
        dp[1] = p[0];
        for (int i = 2; i <= n ; i ++) {
            dp[i] = p[i - 1]; // 如果前面的问题都不能做 (这行代码其实可以和最后的合并)
            for (int j = i - 1; j >= 1; j --) {
                if (j + w[j - 1] < i) {
                    dp[i] = Math.max(dp[i], dp[j] + p[i - 1]); // 做此题
                }
            }
            dp[i] = Math.max(dp[i], dp[i - 1]); //不做此题
        }
        return dp[n];
    }
}
