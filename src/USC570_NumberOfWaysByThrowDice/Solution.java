package USC570_NumberOfWaysByThrowDice;
/*
* 我首先考虑简单的方法 看看是不是也可以做得出来(最后发现常规的背包问题解法好像不太好解这道题)
* 一般的可重复选背包问题只有一个上限 但这题稍微特殊一些 还有有一个次数限制n 也就是说 有两个上限 n 和 m
* 正常的思路是dp[i] = 求和dp[i - r](1 < r < m) 表示当前新增的1需要再投一次骰子补上 补上1的选择有1, 2, ..., m
* 但是因为上限n的限制 思路就需要变成dp[i][j] = 求和dp[i - 1][j - r](1 < r < m)
*
* base case 不太好想 见代码中注释
* 已经在f循环条件限制了的
* dp[0][0] = 1 但是永远不会取到 以为basecase是从1开始 而且每次是i-1 所以到dp[1][j]的时候就停了
* dp[i][0] = 0 因为除非i = 0 否则没有这种可能
* dp[i][1] = 0 除非i = 1 否则肯定为零了
*
* 可用来优化代码的
* dp[i][j](j > Math.max(m, z)) = 0 这种情况不会出现
* dp[i][j](j > i * m) = 0 这种情况无法组成 无需计算直接为0
*
* 此代码还有多处可以优化 见Solution2
* */
public class Solution {
    public int numberOfWaysByThrowDice(int n, int m, int z) {
        int[][] dp = new int[n + 1][z + 1];

        /* base case */
        for(int j = 1; j <= m; j ++) { //掷一次骰子 必然只能得到骰子上有的数 0或者比m大的数都是得不到的 为0
            dp[1][j] = 1;
        }

        /* dp */
        for(int i = 2; i <= n; i ++) {
            for (int j = 1; j <= z; j ++) { //j不取0 因为dp[i][0]肯定是0 java中默认赋值就是0 感觉此处可以优化 j <= i * m就够了 不需要<= z
                for (int r = 1; r <= m; r ++) {
                    if (j - r <= 0)
                        continue; // 设为0 代表不可能
                    dp[i][j] = dp[i][j] + dp[i - 1][j - r];
                }
            }
        }
        return dp[n][z];
    }
}
