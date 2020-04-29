package No516_LongestPalindromicSubsequence;

class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if (len <= 1)
            return len;
        int[][] dp = new int[len][len];

        /* base case */
        for (int i = 0; i <= len - 1; i ++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i <= len - 2; i ++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? 2 : 1;
        }

        /* dp */
        for (int j = 2; j <= len - 1; j ++) {
            for (int i = j - 2; i >=0; i --) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }

    public static void main(String[] agrs) {
        Solution s = new Solution();
        String str = "cbbd";
        //String str = "abcdef";
        int res = s.longestPalindromeSubseq(str);
        System.out.print(res);
    }

}
