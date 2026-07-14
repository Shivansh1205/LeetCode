class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int[] e : dp) Arrays.fill(e,-1);
        int ans = f(0,0,m,n,dp);
        return ans;
    }
    private int f(int i, int j, int m, int n,int[][] dp){
        if(i>=m || j>=n) return 0;
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int paths = f(i+1,j,m,n,dp) + f(i,j+1,m,n,dp);
        return dp[i][j]=paths;
    }
}