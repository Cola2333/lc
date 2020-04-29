package USC570_SellingRose;

public class Solution {
    public int SellingRose(int n, int v[]) {
        int[] dp = new int[n + 1];

        /* base case */
        dp[0] = 0;

        /* dp */
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= i; j ++) {
                dp[i] = Math.max(dp[i], dp[i - j] + v[j - 1]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        int[] v = new int[]{2, 3, 7, 8, 10};
        int res = solution.SellingRose(n, v);
        System.out.println(res);
    }
}
