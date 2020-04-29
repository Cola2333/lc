package No312_BurstBalloons;

class Solution {
    public int maxCoins(int[] nums) {
        int len1 = nums.length;

        /** 创建新的数组 为其加上边界值 这两个值是不会被戳的 */
        int[] init = new int[len1 + 2];
        init[0] = 1;
        init[len1 + 1] = 1;
        System.arraycopy(nums, 0, init, 1, len1);

        int len2 = len1 + 2;
        int[][] dp = new int[len2][len2];

        /** base cases */
        for (int i = 0; i <= len2 - 3; i ++) {
            dp[i][i + 2] = init[i] * init[i + 1] * init[i + 2]; //只有一个气球可以戳
        }

        /** 因为默认值就是0 所以没必要写 其实循环里也用不到这两种情况 因为r的循环条件上已经限制了 */
//        for (int i = 0; i <= len2 - 2; i ++) {
//        	dp[i][i + 1] = 0; // 没得戳
//        }
//
//        for (int i = 0; i <= len2 - 1; i ++) {
//        	dp[i][i] = 0; // 左右边界重合
//        }

        /** dp 最终要求[0, len - 1] 也因此 j应该在外层 */
        /** 边界不会被戳 即j和i都不会被戳 所以从3开始 这样可以戳1或2
         *  之所以不从2开始是因为 若从2开始 则只可以戳1 和base cases重合了 */
        for (int j = 3; j <= len2 - 1; j ++) {
            for (int i = j - 3; i >= 0; i --) {
                for (int r = i + 1; r < j; r ++) {
                    // 注意i, j是边界值 不会被戳 所以子问题其实是求戳i + 1 到j - 1个气球能得到的coins
                    // 如果我们最后戳第r个气球 那么我们要确定(i + 1, r - 1)及(r + 1,j - 1)这两个个子问题的coins是最大的
                    // 但是 我们需要给这两个子问题加上边界值 也就是(i, r)和(r, j)的coins是最大的
                    dp[i][j] = Math.max(dp[i][j], init[i] * init[r] * init[j] + dp[i][r] + dp[r][j]);
                }
            }
        }
        return dp[0][len2 - 1];
    }

    public static void main(String[] args) {
        Solution s  = new Solution();
        int[] nums = new int[] {3, 1, 5, 8};
        int res = s.maxCoins(nums);
        System.out.print(res);
    }
}
