class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        // for(int[] a : ans){
        //     Arrays.fill(a,Integer.MAX_VALUE);
        // }
        int[][] vis = new int[m][n];
        Queue<tri> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                vis[i][j]=0;
                if(mat[i][j] == 0){
                    ans[i][j] =0;
                    q.add(new tri(i,j,0));
                    vis[i][j] = 1;
                }
            }
        }
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,-1,1};
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int dist = q.peek().dist;  
            q.remove(); 
            for(int i=0;i<4;i++){
                int nr = row + dr[i];
                int nc = col + dc[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n && vis[nr][nc] == 0){

                    ans[nr][nc] = dist+1;
                    q.add(new tri(nr,nc,dist+1));
                    vis[nr][nc]=1;
                    
                }
            }
        }
        return ans;
    }
}
class tri{
    int row;
    int col;
    int dist;
    public tri(int row, int col, int dist){
        this.row = row;
        this.col= col;
        this.dist = dist;
    }
}