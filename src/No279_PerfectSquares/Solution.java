package No279_PerfectSquares;
/*
* 用背包问题的思维最好解 但是可能不是最优解
* */
class Solution {
    public int numSquares(int n) {
        int R = (int) Math.sqrt(n);
        int C = n;
        int[][]dp = new int[R + 1][C + 1];

        /* base case 用0作为basecase问题会更复杂*/
        for (int j = 0; j <= C; j ++) {
            dp[1][j] = j;
        }
        for (int i = 0; i <= R; i ++) {
            dp[i][1] = 1;
        }

        /* dp */
        for (int i = 2; i <= R; i ++) {
            for (int j = 2; j <= C; j ++) {
                if (i * i > j) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.min(dp[i][j - i * i] + 1, dp[i - 1][j]);
            }
        }
        return dp[R][C];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 13;
        int res = s.numSquares(n);
        System.out.print(res);

    }
}
