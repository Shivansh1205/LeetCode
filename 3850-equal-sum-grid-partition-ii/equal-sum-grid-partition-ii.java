class Solution {
    private void reverse(int[][] grid) {
        int top = 0, bottom = grid.length - 1;

        while (top < bottom) {
            int[] temp = grid[top];
            grid[top] = grid[bottom];
            grid[bottom] = temp;

            top++;
            bottom--;
        }
    }
    public boolean checkhor(int[][] grid, long total){
        long top=0;
        Set<Long> set = new HashSet<>();
        for(int i=0;i<grid.length-1;i++){
            for(int j=0;j<grid[0].length;j++){
                top+=grid[i][j];
                set.add((long)grid[i][j]);
            }
            long bot = total -top;
            long diff = top-bot;
            if(diff ==0 ) return true;
            if (diff == grid[0][0]) return true;
            if (diff == grid[0][grid[0].length - 1]) return true;
            if (diff == grid[i][0]) return true;

            if(i>0 && grid[0].length>1 && set.contains(diff)) return true;
        }
        return false;
    }
    public boolean canPartitionGrid(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        long total = 0;
        int[][] trans = new int[n][m];

        // Row sums
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
                trans[j][i] = grid[i][j];
                //hor[i] += grid[i][j];
                //ver[j] += grid[i][j];
            }
        }
        if(checkhor(grid,total)) return true;
        reverse(grid);
        if(checkhor(grid,total)) return true;
        reverse(grid);
        if(checkhor(trans,total)) return true;
        reverse(trans);
        if(checkhor(trans,total)) return true;
        return false;
    }
}