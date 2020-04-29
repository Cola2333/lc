package No132_PalindromePartitioningII;

class Solution2 {
    public int minCut(String s) {
        int len = s.length();

        int[][] dp = new int[len][len];

        /* base case */
        for (int i = 0; i <= len - 1; i ++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i <= len - 2; i ++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
            }
            else {
                dp[i][i + 1] = 2;
            }
        }

        /* dp */
        for (int j = 2; j <= len - 1; j ++) {
            for (int i = j - 2; i >= 0; i --) {
                dp[i][j] = len;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) { //只有满足这个条件才可能为回文数
                    dp[i][j] = 1;
                }
                else { // 需要遍历各种的分割方式找到由最少回文数组成
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]) + 1;
                }
            }
        }
        return dp[0][len - 1] - 1; //dp里存的是这个数最少可以由几个回文数组成 将其分开自然需要-1
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        String str = "aabacc";
        int res = s.minCut(str);
        System.out.println(res);

    }
}