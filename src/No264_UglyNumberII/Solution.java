package No264_UglyNumberII;
/*
* 其实和重复选择的背包问题也有相似之处 都是通过遍历之前的值然后进行操作 得到当前层的值
* 感觉以后做题可以首先想这个思路 不行的话在考虑背包问题 最后考虑无规则dp
*
* 大体思路是当前dp[i]必然可以由之前的某个dp[j](j < i) 乘上2或3或5得到 我们只需要找到这些dp[j]乘上2或3或5之后 大于dp[i - 1]的 最小的数
* */
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];

        /* base case */
        dp[0] = 1;

        /* dp */
        for (int i = 1; i < n; i ++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j ++) {
                if (dp[j] * 2 > dp[i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] * 2);
                    break; // 一定比后面所有的都小 结束循环（但是怀疑dp[i]并不一定是在这个if里算出来的 可能是之前的循环算出来但是并没结束）
                }
                if (dp[j] * 3 > dp[i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] * 3);
                    continue; //一定比*5的时候小 所以当前循环的结束
                }
                if (dp[j] * 5 > dp[i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] * 5);
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 1600;
        int res = solution.nthUglyNumber(n);
        System.out.println(res);
    }
}
