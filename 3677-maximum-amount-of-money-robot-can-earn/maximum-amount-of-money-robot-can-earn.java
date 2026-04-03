class Solution {
    public int maximumAmount(int[][] coins) {
        int[][][] dp = new int[coins.length][coins[0].length][3];
        for(int[][] a : dp){
            for(int[] b: a){
                Arrays.fill(b,Integer.MIN_VALUE);
            }
        }
        int ans = f(0,0,2,coins,dp);
        return ans;
    }
    private int f(int i, int j, int neu,int[][] coins,int[][][] dp){
        int m=coins.length;
        int n = coins[0].length;
        if(i==m-1 && j == n-1){
            if(coins[i][j] <0 && neu>0) return 0;
            return coins[i][j];
        }
        if(i>=m || j>=n) return Integer.MIN_VALUE;
        if(dp[i][j][neu]!=Integer.MIN_VALUE) return dp[i][j][neu];
        int take = coins[i][j] + Math.max(f(i+1,j,neu,coins,dp),f(i,j+1,neu,coins,dp));
        int skip = Integer.MIN_VALUE;
        if(coins[i][j]<0 && neu>0){
            int sd = f(i+1,j,neu-1,coins,dp);
            int sr = f(i,j+1,neu-1,coins,dp);
            skip = Math.max(sd,sr);
        }
        return dp[i][j][neu] = Math.max(take,skip);
    }
}