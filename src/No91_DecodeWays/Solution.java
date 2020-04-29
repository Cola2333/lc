package No91_DecodeWays;

class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        /** 处理0 */
        //如果有两0相连 肯定不行
        for (int i = 1; i < len; i ++) {
            if (s.charAt(i - 1) == '0' && s.charAt(i) == '0')
                return 0;
        }
        //如果开头是0肯定不行
        if (s.charAt(0) == '0')
            return 0;
        //若果结尾是0 则只剩一种情况

        int[] dp = new int[len + 1];
        //当前字符串s可能是从 s - 2 或 s - 1 添加一位或者两位数得到的(1-26 只能添加1位或者2位 不可能添加0位或者三位及以上)
        //dp[i] = dp[i - 2] + dp[i - 1]

        /** base case */
        dp[0] = 1; // dp[0]代表分解成null和整体 22可以分解成 2 + 2 或者 null + 22
        dp[1] = 1;

        /** dp i代表几个字符 即s[i - 1]个字符 */
        for (int i = 2; i <= len; i ++) {
            if (Integer.parseInt(s.substring(i - 2,i)) > 26 || s.charAt(i - 2) == '0') { //如果最后两位是>26的 或倒数第二位是0 那么这个s只能由s - 1加一位组成
                if (s.charAt(i - 1) == '0') //如果果结尾是0 则s-1的情况也无法满足
                    return 0;
                else
                    dp[i] = dp[i - 1];
            }
            else {
                if (s.charAt(i - 1) == '0') //如果果结尾是0 则s-1的情况无法满足
                    dp[i] = dp[i - 2];
                else
                    dp[i] = dp[i - 2] + dp[i - 1];
            }
        }

        return dp[len];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "227";
//    	String str = "0";
//    	String str = "120";
//    	String str = "101";
        int res = s.numDecodings(str);
        System.out.print(res);
    }
}
