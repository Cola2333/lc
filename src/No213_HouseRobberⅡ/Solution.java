package No213_HouseRobberⅡ;
/*
* 这题也可以直接把原数组copy成两个len-1的数组
* 然后用和198一样的方法 就无需判断len=1的情况
* 那样可能更好理解
* */
class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        if (len == 1) //这一句很必要 因为如果len=1 basecase的dp[1]就会越界
            return nums[0];
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        /* base case */
//        dp1[0] = 0;
        dp1[1] = nums[0];
//        dp2[0] = 0;
        dp2[1] = nums[1];

        /* dp */
        for (int i = 2; i <= len - 1; i ++) {
            dp1[i] = Math.max(nums[i - 1] + dp1[i - 2], dp1[i - 1]);
            dp2[i] = Math.max(nums[i] + dp2[i - 2], dp2[i - 1]);
        }

        return Math.max(dp1[len - 1], dp2[len - 1]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//    	int[] nums = new int[] {2, 3, 2};
        int[] nums = new int[] {1, 2, 3, 1};
//        int[]nums = new int[]{0};
        int res = s.rob(nums);
        System.out.print(res);
    }
}
