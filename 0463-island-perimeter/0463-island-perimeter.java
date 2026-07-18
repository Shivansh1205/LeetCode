class Solution {
    public int islandPerimeter(int[][] grid) {
        int i=0,n=0;
        for(int k=0;k<grid.length;k++){
            for(int j=0;j<grid[k].length;j++){
                if(grid[k][j]==1){
                    i++;
                    if(k<grid.length-1&& grid[k+1][j]==1) n++;
                    if(j<grid[k].length-1&& grid[k][j+1]==1) n++;
                }
            }
        }
        return i*4-n*2;
    }
}