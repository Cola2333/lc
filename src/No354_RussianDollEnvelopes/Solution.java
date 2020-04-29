package No354_RussianDollEnvelopes;
/*
* 和No300思路一致 只不过需要先排序一下
* */
import java.util.Arrays;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;
        if (len == 0) {
            return 0;
        }

        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        int[] dp = new int[len];
        int res = 1;
        /* base case */
        dp[0] = 1;

        /*dp*/
        for (int i = 1; i < len; i ++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j --) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] envelopes = new int[][]{{5,4},{6,4},{6,7},{2,3}};
        int res = solution.maxEnvelopes(envelopes);
        System.out.println(res);
    }
}
