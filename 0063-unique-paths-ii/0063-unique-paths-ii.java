class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int[][] dp =new int[grid.length][grid[0].length];
        for(int[] e : dp ) Arrays.fill(e,-1);
        if(grid[0][0]==1) return 0;
        int ans = f(grid,0,0,dp);
        return ans;
    }
    private int f(int[][] grid,int i, int j,int[][] dp){
        if(i>=grid.length || j>=grid[0].length) return 0;
        if(i== grid.length-1 && j== grid[0].length-1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int p1=0,p2=0;
        if(i+1<grid.length && grid[i+1][j]!=1){
            p1 =f(grid,i+1,j,dp); 
        }
        if(j+1<grid[0].length && grid[i][j+1]!=1){
            p2 = f(grid,i,j+1,dp);
        }
        return dp[i][j]=p1+p2;
    }
}