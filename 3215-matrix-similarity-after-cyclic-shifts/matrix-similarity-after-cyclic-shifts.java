class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m  = mat[0].length;
        int n = mat.length;
        int rem = k%m;
        int[][] ori = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ori[i][j] = mat[i][j];
            }
        }
        if (rem==0) return true;
        int[][] res = new int[n][mat[0].length];
        while(rem-->0){
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<m;j++){
                    if(i%2==1){
                    res[i][(j+1)%m] = mat[i][j];
                    }
                }
            }
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<m;j++){
                    if(i%2==0){
                        res[i][j] = mat[i][(j+1)%m];
                    }
                }
            }
            int[][] tmp = res;
            res = mat;
            mat = tmp;
        }
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<m;j++){
                if(ori[i][j]!=mat[i][j]) return false;
                
            }
        }
        return true;
        
    }
}