package No70_ClimbingStairs;

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i ++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 4;
        int res = s.climbStairs(n);
        System.out.print(res);
    }
}
