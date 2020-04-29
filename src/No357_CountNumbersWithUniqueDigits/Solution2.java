package No357_CountNumbersWithUniqueDigits;
/*
* 也可以dp[0] = 1 dp[1] = 10 这样在开头就只需要写一个if了
* 但是我感觉dp[0]无意义 仅是为了计算dp[1]增加了多少
* */
class Solution2 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 10;

        int[] dp = new int[n + 1];

        /* base case */
        dp[1] = 10;
        dp[2] = 91;

        /* dp */
        for (int i = 3; i <= n; i ++) {
            dp[i] = dp[i - 1] + (dp[i - 1] - dp[i - 2]) * (10 - (i - 1));
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        Solution2 s = new Solution2();
        int res = s.countNumbersWithUniqueDigits(n);
        System.out.println(res);
    }
}
