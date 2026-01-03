class Solution {
    public int minFallingPathSum(int[][] g) {
        int m = g.length;
        int n = g[0].length;
        int ans = (int)1e9;
        int[][]dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) dp[i][j] =  -101;
        }
        for(int i=0;i<n;i++){
            ans = Math.min(ans,f(m-1,i,g,dp));
        }
        return ans;
    }
    public int f(int i,int j,int[][] g, int[][] dp){
        if(j<0 || j>g[0].length-1) return (int)1e9;
        if(i==0) return g[i][j];
        if(dp[i][j]!=-101 ) return dp[i][j];
        int u = f(i-1,j,g,dp);
        int l = f(i-1,j-1,g,dp);
        int r = f(i-1,j+1,g,dp);
        return dp[i][j] =g[i][j]+Math.min(u,Math.min(l,r));
    }
}