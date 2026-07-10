class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+2];
        Arrays.fill(dp,-1);
        int ans = f(n, 0,dp);
        return ans;
    }
    private int f(int n, int i, int[] dp){
        if(i==n) return 1;
        if(dp[i]!=-1) return dp[i];
        int step1=0, step2=0;
        if(i<n){
            step1 = f(n,i+1,dp);
            step2 = f(n,i+2,dp);
        }
        return dp[i]=step1+step2;
    }
}