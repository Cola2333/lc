package No5_LongestPalindromicSubstring;

class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        String res = "";
        if(len == 0)
            return res;
        res = s.substring(0, 1); //保证至少有长度为一的回文 因为dp的过程中可能一共回文都没有
        int max = 1;

        /* base case */
        for (int i = 0; i <= len - 1; i ++) {
            dp[i][i] = true;
        }
        for (int i = 0; i <= len - 2; i ++) { //这个循环可以和上一个合并 但是我觉得这样更好理解
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (dp[i][i + 1] && max < 2) {
                res = s.substring(i, i + 2); // 保证至少有长度为二的回文 同上
                max = 2;
            }
        }

        /* dp */
        for (int j = 2; j <= len - 1; j ++) {
            for (int i = j - 2; i >= 0; i --) {
                if(s.charAt(i) == s.charAt(j)) { //只有这样才 可能 为true
                    dp[i][j] = dp[i + 1][j - 1];
                    if (dp[i][j] && j - i + 1> max) {
                        res = s.substring(i, j + 1);
                        max = j - i + 1;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aaabaaaa";
        String res = solution.longestPalindrome(s);
        System.out.print(res);
    }
}
