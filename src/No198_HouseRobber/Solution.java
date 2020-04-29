package No198_HouseRobber;

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
//        if (len == 1)
//            return nums[0];

        int[] dp = new int[len + 1];
        /* base case */
        dp[0] = 0;
        dp[1] = nums[0];

        /* dp */
        for (int i = 2; i <= len; i ++) {
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
        }
        return dp[len];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[] {2, 7, 9, 3, 1};
        int res = s.rob(nums);
        System.out.print(res);
    }
}
