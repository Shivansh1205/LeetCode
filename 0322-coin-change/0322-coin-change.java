class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        int ans = f(coins, amount,coins.length-1,dp);
        return ans==(int)1e9?-1:ans;
    }
    private int f(int[] coins, int amount, int idx,int[][]dp){
        if(idx<0) return (int)1e9;
        if(amount ==0) return 0;
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        int np = f(coins, amount, idx-1,dp);
        int p=(int)1e9;
        if(coins[idx]<=amount){
            p =1+ f(coins,amount-coins[idx],idx,dp);
        }
        return dp[idx][amount]=Math.min(p,np);
    }
}