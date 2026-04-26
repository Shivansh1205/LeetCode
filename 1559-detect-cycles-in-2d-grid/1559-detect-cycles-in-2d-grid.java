class Solution {
    public boolean containsCycle(char[][] grid) {
        boolean[][] A = new boolean[grid.length][grid[0].length];
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!A[i][j] && dfs(i,j,-1,-1,grid,A,m,n)) return true;
            }
        }
        return false;
    }
    private static boolean dfs(int i, int j, int pr, int pc, char[][] grid, boolean[][] A, int m, int n){
        A[i][j] = true;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        for(int k=0;k<4;k++){
            int nr = i + dx[k];
            int nc = j+dy[k];
            if(nr!=pr || nc!=pc){
                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    if(grid[nr][nc] == grid[i][j]){
                        if(A[nr][nc] || dfs(nr,nc,i,j,grid,A,m,n)) return true;
                    }
                }
            }
        }
        return false;
    }
}