class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m= board[0].length;
        int[][] vis = new int[board.length][board[0].length];
        for(int i=0;i<n;i++){
            if(vis[i][0] ==0 && board[i][0] == 'O'){
                dfs(i,0,vis,board);
            }
            if(vis[i][m-1] ==0 && board[i][m-1] == 'O'){
                dfs(i,m-1,vis,board);
            }
        }
        for(int j=0;j<m;j++){
            if(vis[0][j] == 0 && board[0][j] =='O'){
                dfs(0,j,vis,board);
            }
            if(vis[n-1][j]==0 && board[n-1][j]=='O'){
                dfs(n-1,j,vis,board);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] ==0 ) board[i][j] = 'X';
            }
        }
    }
    private void dfs(int row, int col, int[][] vis, char[][] board){
        int n = board.length;
        int m = board[0].length;
        vis[row][col] =1;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        for(int i=0;i<4;i++){
            int nr = row + dr[i];
            int nc = col + dc[i];
            if(nr<n && nr>=0 && nc<m && nc >=0 && vis[nr][nc] ==0 && board[nr][nc] == 'O')
                dfs(nr,nc,vis,board);
        }
    }
}