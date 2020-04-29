package No343_IntegerBreak;
/*
* 子问题 OPT[i]表示i被分割可以得到的最大乘积
*
* 如果是一个可以重复选择的背包问题 那么 可以选择用另一种特殊的解法
* 对于此题来讲 n一定是由第n - 1 和1 或n - 2 和 2 ... 组成的
* 而且n - 1 n - 2都是之前求出来了的值 所以 一维数组就足够了
* 但这题比较特殊 要求必须分割成两个及以上的数 所以在i = n时要特殊处理一下 使其不会分成0和n.
* */
class Solution3 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];

        /* base case */
//        dp[0] = 0;
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i ++) {
            if (i == n) {
                for (int j = i - 1; j >= 1; j --) {
                    dp[i] = Math.max(dp[i], dp[j] * (i - j));
                }
            }
            else {
                for (int j = i - 1; j >= 0; j--) { //j从小到大也可以 状态方程也是这个, 如果j从1到i或从i到1, 状态方程会有些改变
                    dp[i] = Math.max(dp[i], dp[j] * (i - j)); //dp[i] = Max(dp[i], dp[i - j]*(j))
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Solution3 s = new Solution3();
        int n = 10;
        int res = s.integerBreak(n);
        System.out.println(res);
    }
}
