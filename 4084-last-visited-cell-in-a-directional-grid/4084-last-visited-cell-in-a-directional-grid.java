class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int x = 0;
        int y = 0;
        int lastX = 0;
        int lastY = 0;
        while(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != 'X') {
            lastX = x;
            lastY = y;
            switch(grid[x][y]) {
                case 'U' -> x--;
                case 'D' -> x++;
                case 'L' -> y--;
                case 'R' -> y++;
            }
            grid[lastX][lastY] = 'X';
        }
        return new int[]{lastX,lastY};
    }
}