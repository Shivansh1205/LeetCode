class Solution {
  public int minPathSum(int[][] g) {
    int m = g.length; 
    int n = g[0].length;
    int[][]dp = new int[m][n];
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++)dp[i][j] =-1;
    }
    int ans= f(m-1,n-1,g,dp);
    return ans;
  }
  public int f(int i,int j,int[][] g,int[][] dp){
    if(i==0 && j==0 ) return g[0][0];
    if(i<0 || j<0) return (int)1e9;
    if(dp[i][j]!=-1) return dp[i][j];
    int up = g[i][j]+f(i-1,j,g,dp);
    int left = g[i][j]+f(i,j-1,g,dp);
    return dp[i][j]= Math.min(up,left);
  }
}