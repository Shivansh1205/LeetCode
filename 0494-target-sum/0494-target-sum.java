class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int x : nums) sum += x;

        Integer[][] dp = new Integer[nums.length][2 * sum + 1];
        return f(nums, target, 0, dp, sum);
    }

    private int f(int[] nums, int target, int i, Integer[][] dp, int offset) {
    if (Math.abs(target) > offset) return 0;

    if (i == nums.length)
        return target == 0 ? 1 : 0;

    if (dp[i][target + offset] != null)
        return dp[i][target + offset];

    int add = f(nums, target - nums[i], i + 1, dp, offset);
    int sub = f(nums, target + nums[i], i + 1, dp, offset);

    return dp[i][target + offset] = add + sub;
}
}