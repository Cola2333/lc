package No10_RegularExpressionMatching;
/*
* 其实题目可以理解为*会使得前面的字符使用0次或多次 可以将*和其前面的字母看作一体
* '.' 不能够匹配空
* '.*' 可以理解成零或多个'.' 即可以匹配任意字符
* 'a**' 不可以匹配空 因为'*'匹配零个或多个前面的那一个元素
*   1. 若第一个*匹配零个a 那么就变成'*' 显然为false
*   2. 若第一个*匹配多个a 那么就变成'aa*' 显然为false
*
* */
class Solution {
    public boolean isMatch(String s, String p) {
        int len = s.length();
        int len2 = p.length();

        boolean[][] dp = new boolean[len + 1][len2 + 1];

        /* base case */
        dp[0][0] = true;
        for (int j = 2; j <= len2; j ++) {
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        }

        /* dp */
        for (int i = 1; i <= len; i ++) {
            for (int j = 1; j <= len2; j ++) {
                char c = p.charAt(j - 1);
                if (c == '.' || c == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (c == '*'){
                    char c2 = p.charAt(j - 2);
                    if (c2 == '.' || c2 == s.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - 2] || dp[i][j - 2];
                    }
                    else if (c2 == '*') {
                        dp[i][j] = dp[i][j - 1];
                    }
                    else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[len][len2];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//    	String str = "mississippi";
//    	String p = "mis*is*p*.";

        String str = "aab";
        String p = "c*a*b";
        boolean res = s.isMatch(str, p);
        System.out.print(res);
    }
}
