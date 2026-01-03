class Solution {
    public int minFallingPathSum(int[][] g) {
        int m = g.length;
        int n = g[0].length;
        int ans = (int)1e9;
        int[][]dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) dp[i][j] =  -101;
        }
        for(int j=0;j<n;j++) dp[0][j] = g[0][j];
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                int u = dp[i-1][j];
                int l = (int)1e9,r=(int)1e9;
                if(j>0){
                    l=dp[i-1][j-1];
                }
                if(j<n-1){
                    r=dp[i-1][j+1];
                }
                dp[i][j] = g[i][j]+Math.min(u,Math.min(l,r));
            }
        }
        for(int i=0;i<n;i++){
            ans = Math.min(ans,dp[m-1][i]);
        }
        return ans;
    }
}