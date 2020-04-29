package No97_InterleavingString;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        if (len1 + len2 != len3) {
            return false;
        }

        boolean[][] dp = new boolean[len1 + 1][len2 + 1]; //增加了第0个字符 即不选的情况 所以是从0到len
        /* base cas i和j代表第几个字符 即第1个到第len个 第i个字符是charAt(i - 1)*/
        dp[0][0] = true;
        for (int j = 1; j <= len2; j ++) {
            dp[0][j] = dp[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
        }
        for (int i = 1; i <= len1; i ++) {
            dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }

        /* dp */
        for (int i = 1; i <= len1; i ++) {
            for (int j = 1; j <= len2; j ++) {
                dp[i][j] = (dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1))) || (dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1)));
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        boolean res = s.isInterleave(s1, s2, s3);
        System.out.print(res);
    }
}
