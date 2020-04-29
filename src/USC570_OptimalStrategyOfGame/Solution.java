package USC570_OptimalStrategyOfGame;

public class Solution {
    int optimalStrategyOfGame(int arr[], int n) {
        int[][] dp = new int[n][n];

        /* base case */
        for (int i = 0; i < n; i ++) {
            dp[i][i] = arr[i];
        }
        for (int i = 0; i < n - 1; i ++) {
            dp[i][i + 1] = Math.max(arr[i], arr[i + 1]);
        }

        /* dp */
        for (int j = 2; j < n; j ++) {
            for (int i = j - 2; i >= 0; i --) {
                dp[i][j] = Math.max(Math.min(dp[i + 2][j], dp[i + 1][j - 1]) + arr[i], Math.min(dp[i + 1][j - 1], dp[i][j - 2]) + arr[j]);
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int arr[] = new int[]{8 ,15, 3 ,7};
        int n = arr.length;
        int res = solution.optimalStrategyOfGame(arr, n);
        System.out.println(res);
    }
}
