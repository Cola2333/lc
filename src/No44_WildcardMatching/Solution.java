package No44_WildcardMatching;
/*
* dp[i][j]表示s的前i个字符被p的前j个字符匹配
* */
class Solution {
    public boolean isMatch(String s, String p) {
        int len = s.length();
        int len2 = p.length();
        if(len2 == 0)
            return len == 0;
        if (len == 0) {
            for (char c : p.toCharArray()) {
                if (c != '*')
                    return false;
            }
        }

        boolean[][] dp = new boolean[len + 1][len2 + 1]; //有匹配空值 所以加一

        /* base case */
        dp[0][0] = true;
        for (int j = 1 ; j <= len2; j ++) {
            dp[0][j] = dp[0][j - 1] && p.charAt(j - 1) == '*';
        }
//        for (int i = 1; i <= len; i ++) {
//            dp[i][0] = false;
//        }

        /* dp */
        for (int i = 1; i <= len; i ++) {
            for (int j = 1; j <= len2; j ++) {
                char c = p.charAt(j - 1);
                if (c == '*') {
                    // dp[i - 1][j], dp[i - 1][j - 1] 只保留dp[i - 1][j]即可 因为当前决定‘*’只匹配单个 就相当于下一次决定‘*’匹配空值
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - 1] || dp[i][j - 1];
                }
                else if (c == '?' || c == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[len][len2];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "adceb";
        String p = "*a*b";

//    	String str = "a";
//    	String p = "a*";
        boolean res = s.isMatch(str, p);
        System.out.print(res);
    }
}
