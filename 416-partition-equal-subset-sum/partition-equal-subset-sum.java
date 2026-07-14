class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int x : nums) sum += x;

        if ((sum & 1) == 1) return false;

        Boolean[][] dp = new Boolean[nums.length][sum / 2 + 1];

        return f(nums, sum / 2, 0, dp);
    }

    private boolean f(int[] nums, int sum, int i, Boolean[][] dp) {
        if (sum == 0) return true;
        if (i == nums.length) return false;

        if (dp[i][sum] != null) return dp[i][sum];

        boolean pick = false;
        if (nums[i] <= sum)
            pick = f(nums, sum - nums[i], i + 1, dp);

        boolean notPick = f(nums, sum, i + 1, dp);

        return dp[i][sum] = pick || notPick;
    }
}