class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[][] dp = new Integer[coins.length][amount+1];

        int ans = f(coins, amount, 0,dp);
        return ans>=(int)1e9?-1:ans;
    }
    private int f(int[] nums, int  target, int i,Integer[][] dp){
        if(i ==nums.length-1){
            if(target%nums[i] ==0) return target/nums[i];
            else return (int)1e9;
        }
        if(dp[i][target] != null) return (int)dp[i][target];
        int np = 0 + f(nums,target,i+1,dp);
        int p =(int) 1e9;
        if(nums[i] <=target){
            p = 1+f(nums,target-nums[i],i,dp);
        }
        int res = Math.min(p,np);
        return dp[i][target]=res;
    }
}