package No343_IntegerBreak;
/*
* 背包问题：相当于1, 2, ..., n - 1备选 “重量”是1, 2, ..., n
* 问题的关键在于base case:dp[1][j]显然都应该为1(j个1相乘)
*                        dp[i][1] 可以将其设为1 但是dp中直接通过if中也会直接取上层值 去到最后是dp[1][1]即1
* 需要注意的是dp[i][0] 这种情况下表示n正好被分割完 所以应为 1
* 因此其实Solution2的解法更好一些
* */

import javax.swing.*;

class Solution {
    public int integerBreak(int n) {
        int R = n - 1;
        int C = n;

        int[][] dp = new int[R + 1][C + 1];

        /* base case */
        for (int j = 1; j <= C; j ++) {
            dp[1][j] = 1;
//            dp[0][j] // 永远不取到
        }
        for (int i = 1; i <= R;  i++) { //其实这个已经在下面的dp里被if处理了
            dp[i][1] = 1;
            dp[i][0] = 1; // 可能会取到 代表正好将n分割完
        }

        /* dp */
        for (int i = 2; i <= R; i ++) {
            for (int j = 2; j <= C; j ++) {
                if (i > j) { // 不需要限制i=j, 因为所求为n 而i只到n-1 所以不可能只分割一次
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - i] * i);
            }
        }
        return dp[R][C];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 10;
        int res = s.integerBreak(n);
        System.out.println(res);
    }
}
