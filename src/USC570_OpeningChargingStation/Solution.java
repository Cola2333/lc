package USC570_OpeningChargingStation;
/*
* 和USC570_HighestPossibleScore很像
*
* Let OPT(k) be the maximum expected profit which you can obtain from locations 1, 2, …, k.
* OPT(k) = max{OPT(k − 1), pk + OPT(f(k))} where f(k) finds the largest index j such that d j ≤ d k − M, when such j does not exist, f(k)=0
* 其实这个写法很好 写成f容易看的出 f可以采取二分法 这样可以把时间复杂度降到O(n log n)
* 在此 我先写O(n^2)的代码
* */
public class Solution {
    public int openingChargingStation(int n, int[] d, int[] p, int m) {
        int[] dp = new int[n + 1];

        /* base case */
        dp[0] = 0;
        dp[1] = p[0];

        /* dp */
        for (int i = 2; i <= n; i ++) {
            for (int j = i - 1; j >= 1; j --) { //这一部分可以用二分查找
                if (d[i] - d[j] >= m) {
                    dp[i] = dp[j] + p[i - 1];
                }
            }
            dp[i] = Math.max(dp[i], p[i - 1]); //可能找不到满足条件的dp[j]
            dp[i] = Math.max(dp[i], dp[i - 1]); //比较建和不建
        }
        return dp[n];
    }
}
