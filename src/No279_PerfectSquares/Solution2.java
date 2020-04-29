package No279_PerfectSquares;
/*
* 去readme看看问题本质 完全适用本题
* 想要求dp[i] 肯定要再选square 而且一定是再选一个(如果选一个以上显然不会是最优) 那我们就只需看从选择数组选择哪个 得到的dp[j] + 1最小
* */
class Solution2 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        /* base case */
        dp[0] = 0;
        dp[1] = 1;

        /* dp */
        for (int i = 2; i <= n; i ++) {
            dp[i] = n;
            for (int j = 1; j <= (int)Math.sqrt(n); j ++) {
                if (j * j > i) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int n = 13;
        int res = s.numSquares(n);
        System.out.print(res);

    }
}
