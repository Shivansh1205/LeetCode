class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2==1)return false;
        int[][] dp = new int[nums.length][sum];
        for(int[] a: dp){
            Arrays.fill(a,-1);
        }
        return f(nums,nums.length-1,sum/2,dp);
    }
    private boolean f(int[] nums, int idx, int sum, int[][] dp){
        if(sum == 0 )return true;
        if(idx==0) return (nums[0] == sum);
        if(dp[idx][sum]!=-1) return dp[idx][sum]==1;
        boolean nt = f(nums,idx-1,sum,dp);
        boolean t = false;
        if(sum>=nums[idx]){
            t = f(nums, idx-1,sum-nums[idx],dp);
        }
        dp[idx][sum] = t||nt?1:0;
        return t||nt;
    }
}