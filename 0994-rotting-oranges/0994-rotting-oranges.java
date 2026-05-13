class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt=0;
        int cntf=0;
        Queue<pair> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] ==2){
                    q.add(new pair(i,j,0));
                    vis[i][j]=2;
                }
                else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1) cntf++;
            }
        }
        int[] dr = {-1,0,0,1};
        int[] dc = {0,-1,1,0};
        int tm=0;
        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            int t = q.peek().time;
            tm = Math.max(tm,t);
            q.remove();
            for(int i=0;i<4;i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(nr>=0 && nr<n &&nc >=0 && nc<m && grid[nr][nc]==1 && vis[nr][nc]==0){
                    q.add(new pair(nr,nc,t+1));
                    cnt++;
                    vis[nr][nc] = 2;
                }
            }
            
        }
        return cnt==cntf?tm:-1;
    }
}
class pair{
    int first;
    int second;
    int time;
    public pair(int first,int second,int time){
        this.first = first;
        this.second = second;
        this.time=time;
    }
}