class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row: dp) Arrays.fill(row, -1);
        return search(m, n, 0, 0, dp);
    }

    public int search(int m, int n, int row, int col, int[][] dp) {
        if (row == m-1 && col == n-1) return 1;
        if (row >= m || col >= n) return 0;
        if (dp[row][col] != -1) return dp[row][col];

        dp[row][col] = search(m, n, row+1, col, dp) + search(m, n, row, col+1, dp);
        return dp[row][col];
    }
}
