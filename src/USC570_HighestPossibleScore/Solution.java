package USC570_HighestPossibleScore;
/*
* 如果题目要求中增加一个上限W 那么这个题就会变成一个不可重复选的背包问题
*
* 倒着的写法 直接按照题目的逻辑
* 争着的写法复杂度较高 见Solution2
* */
public class Solution {
    public int highestPossibleScore(int n, int[] p, int[] w) {
        int[] dp = new int[n + 1];

        /* base case */
        dp[n] = p[n - 1]; // p[n - 1]也就是题目中的pn

        /* dp */
        for (int i = n - 1; i >= 0; i ++) {
            if (dp[i + w[i] + 1] > n) {
                dp[i] = Math.max(dp[i + 1], p[i - 1]);
            }
            dp[i] = Math.max(dp[i + 1], dp[i + w[i] + 1] + p[i - 1]);
        }
        return dp[1];
    }
}
