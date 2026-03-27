class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m  = mat[0].length;
        int n = mat.length;
        k = k%m;
        if(k==0) return true;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]!=mat[i][(j-k+m)%m]) return false;
            }
        }
        return true;
    }
}