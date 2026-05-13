class Solution {
    public int[][] highestPeak(int[][] mat) {
        int n =mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        for(int[] a : ans) Arrays.fill(a,-1);
        Queue<pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 1){
                    q.add(new pair(i,j));
                    ans[i][j]=0;
                }
            }
        }
        int[] dr = {-1,0,0,1};
        int[] dc = {0,-1,1,0};
        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            q.remove();
            for(int i=0;i<4;i++){
                int nr = r+dr[i];
                int nc= c+dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && ans[nr][nc]==-1){
                    q.add(new pair(nr,nc));
                    ans[nr][nc] = ans[r][c] +1;
                }
                
            }

        }
        return ans;
    }
}
class pair{
    int first;
    int second;
    public pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}