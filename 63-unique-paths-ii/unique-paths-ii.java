class Solution {
    public int uniquePathsWithObstacles(int[][] g) {
        int m = g.length;
        int n= g[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) dp[i][j] =-1;
        }
        int ans=f(g.length-1,g[0].length-1,dp,g);
        return ans;
    }
    public int f(int i,int j,int[][]dp,int[][]g){
        if(i>=0 && j>=0 &&g[i][j]==1) return 0;
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int up = f(i-1,j,dp,g);
        int left = f(i,j-1,dp,g);
        return dp[i][j] = up+left;
    }
}