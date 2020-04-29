package No300_LongestIncreasingSubsequence;
/*
* 遍历之前的情况(j < i) 寻找满足nums[i] > nums[j]并且dp[j] + 1最大的
* 注意 即使找到了 也要继续遍历 因为第一个找到的并非是最大的 dp[i]表示i位置时的最大上升子序列 dp[i]是有可能比dp[i - 1]小的
* 也因此 需要添加一个参数来记录dp[i]中的最大值 而不是直接返回dp[n - 1]
* */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1)
            return len;
        int[] dp = new int[len];
        int res = 1;

        /* base case */
        dp[0] = 1;

        /* dp */
        for (int i = 1; i < len ; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j --) {
                if (nums[i] > nums[j])
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,3,6,7,9,4,10,5,6};
        int res = solution.lengthOfLIS(nums);
        System.out.println(res);
    }

}
