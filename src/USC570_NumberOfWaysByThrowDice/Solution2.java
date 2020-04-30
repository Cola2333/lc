package USC570_NumberOfWaysByThrowDice;

public class Solution2 {
    public int numberOfWaysByThrowDice(int n, int m, int z) {
        int[][] dp = new int[n + 1][z + 1];

        /* base case */
        for(int j = 1; j <= m; j ++) { //掷一次骰子 必然只能得到骰子上有的数 0或者比m大的数都是得不到的 为0
            dp[1][j] = 1;
        }

        /* dp */
        for(int i = 2; i <= n; i ++) {
            for (int j = 1; j <= Math.min(z, i * m); j ++) { //如果j > i * m 显然已经无法组成 如果j > z 显然不会出现这种情况
                for (int r = 1; r < j; r ++) { //若果r >= j 显然无法组成(其实可以写成 r < j - 1, 以为如果j - r = 1 那么就会得到一个dp[i][1](i > 1)显然也是无法组成的)
                    dp[i][j] = dp[i][j] + dp[i - 1][j - r];
                }
            }
        }
        return dp[n][z];
    }
}
