class Solution {
    public int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        Integer[][] dp = new Integer[n+1][n+1];
        int ans = f(n,1,dp);
        return ans;
    }
    private int f(int n, int i,Integer[][] dp){
        if(n==0){
            return 1;
        }
        if(i>n) return Integer.MIN_VALUE;
        if(dp[n][i]!=null) return dp[n][i];
        int p =-1;
        if(i<=n){
            p = i*f(n-i,i,dp);
        }
        int np = f(n,i+1,dp);
        return dp[n][i] = Math.max(p,np);
    }
}