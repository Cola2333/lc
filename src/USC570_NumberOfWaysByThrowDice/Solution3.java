package USC570_NumberOfWaysByThrowDice;
/*
* 常规背包问题解法 好像不太好想 maybe latter
* */
public class Solution3 {
    public int numberOfWaysByThrowDice(int n, int m, int z) {
        int[][] dp = new int[n + 1][z + 1];

        /* base case */
        for(int j = 1; j <= z; j ++) {
            dp[1][j] = j;
        }
        return 0;
    }
}
