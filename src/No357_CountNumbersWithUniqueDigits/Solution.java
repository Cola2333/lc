package No357_CountNumbersWithUniqueDigits;

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;

        int[] dp = new int[n + 1];

        /* base case */
        dp[1] = 10;

        /* dp */
        for (int i = 2; i <= n; i ++) {
            int sum = 9;
            int j = 0;
            for (; j <= i - 2; j ++) {
                sum *= 9 - j;
            }
            dp[i] = dp[i - 1] + sum;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        Solution s = new Solution();
        int res = s.countNumbersWithUniqueDigits(n);
        System.out.println(res);
    }
}
