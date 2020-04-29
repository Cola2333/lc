package No64_MinimumPathSum;

class Solution {
    public int minPathSum(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        if (R == 0 || C == 0) {
            return 0;
        }
        int[][] dp = new int[R][C];
        /* base case */
        dp[0][0] = grid[0][0];
        for (int j = 1; j < C; j ++) {
          dp[0][j] = grid[0][j] + dp[0][j - 1];
        }
        for (int i = 1; i < R; i ++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        /* dp */
        for (int i = 1; i < R; i ++) {
            for (int j = 1; j < C; j ++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[R - 1][C - 1];
    }

    public static void main(String[] agrs) {
        Solution s = new Solution();
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int res = s.minPathSum(grid);
        System.out.println(res);
    }
}
