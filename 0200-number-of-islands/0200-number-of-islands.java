class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m = grid[0].length;
        
        int[][] vis = new int[n][m];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] ==0 && grid[i][j] == '1'){
                    cnt++;
                    dfs(i,j,vis,grid);
                }
            }
        }
        return cnt;

    }
    private void dfs(int r, int c, int[][]vis, char [][] grid){
        vis[r][c] = 1;
        int n = grid.length;
        int m = grid[0].length;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        for(int i=0;i<4;i++){
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0 && grid[nr][nc] =='1') dfs(nr,nc,vis,grid);
        }
    }
}