class Solution {
    public boolean canPartitionGrid(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        long[] hor = new long[m];   // row sums
        long[] ver = new long[n];   // column sums

        long total = 0;

        // Row sums
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
                hor[i] += grid[i][j];
                ver[j] += grid[i][j];
            }
        }
        if(total%2!=0) return false;
        long up=0;
        for(int i=0;i<hor.length-1;i++){
            up += hor[i];
            if(up == total -up) return true;
        }
        up=0;
        for(int j=0;j<ver.length-1;j++){
            up += ver[j];
            if(up == total - up) return true;
        }
        return false;
    }
}