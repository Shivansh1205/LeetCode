class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length][amount+1];
        int ans = f(coins, amount, 0,dp);
        return ans;
    }
    private int f(int[] nums, int target, int i,Integer[][] dp){
        if(i == nums.length){
            return target==0?1:0;
        }
        if(dp[i][target]!=null) return dp[i][target];
        int np = f(nums,target,i+1,dp);
        int p =0;
        if(nums[i] <=target){
            p = f(nums,target-nums[i],i,dp);
        }
        return dp[i][target] = p+np;
    }
}