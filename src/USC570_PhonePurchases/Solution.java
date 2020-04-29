package USC570_PhonePurchases;
/*
* 这个代码不一定真的可以运行 指示提供思路
*
* 子问题：
* dp[i]表示 保持从0到i始终有手机使用 的最少花费
*
* 想求得dp[i] 我们需要去在i时间之前发布的手机j 而且这个手机要满足从买开始 一定可以使用到时间 i
* 即 tj < i && tj + sj >= i
* 又因为tj < i 所以 dp[tj]肯定是在dp[i]之前已经求出了
* 所以 dp[i] = Min(dp[i], dp[tj] + cj)
*
*
* */
public class Solution {
    public int phonePurchases(int[] time, int[] support, int[] cost, int n) {
        int[] dp = new int[n + 1];

        /* base case */
        dp[0] = 0;

        /* dp */
        for (int i = 1; i <= n; i ++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; time[j] < i; j ++) {
                if (time[j] + support[j] >= i) {
                    dp[i] = Math.min(dp[i], cost[j] + dp[time[j]]);
                }
            }
        }
        return dp[n];
    }
}
