class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Integer[] dp  = new Integer[cost.length+1];
        int a1 = f(cost,0,dp);
        int a2 = f(cost,1,dp);
        return Math.min(a1,a2);
    }
    private int f (int[] cost, int i, Integer[] dp){
        if(i >= cost.length) return 0;
        if(dp[i]!=null) return dp[i];
        int p = f(cost, i+1,dp)+cost[i];
        int p2 = f(cost,i+2,dp) + cost[i];
        return dp[i] = Math.min(p,p2);
    }
}