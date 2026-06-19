class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[grid.length][grid[0].length];
        for(int i=0;i<n;i++){
            if(vis[i][0] ==0 && grid[i][0]==1) dfs(i,0,vis,grid);
            if(vis[i][m-1] ==0 && grid[i][m-1] ==1) dfs(i,m-1,vis,grid);
        }
        for(int j=0;j<m;j++){
            if(vis[0][j]==0 && grid[0][j]==1) dfs(0,j,vis,grid);
            if(vis[n-1][j]==0 && grid[n-1][j] ==1) dfs(n-1,j,vis,grid);
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] ==0 && grid[i][j] ==1 ) cnt++;
            }
        }
        return cnt;
    }
    private void dfs(int row, int col, int[][] vis, int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        vis[row][col] =1;
        int[] dr = {-1,+1,0,0};
        int[] dc = {0,0,-1,1};
        for(int i=0;i<4;i++){
            int nr = row + dr[i];
            int nc = col + dc[i];
            if(nr<n && nr>=0 && nc<m && nc>=0 && vis[nr][nc] ==0 && grid[nr][nc]==1) dfs(nr,nc,vis,grid);
        }
        
    }

}