class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix.length+1];
        for(int[] e : dp ) Arrays.fill(e,-101);
        for (int col = 0; col < n; col++) {
            ans = Math.min(ans, f(matrix, 0, col,dp));
        }

        return ans;
    }

    private int f(int[][] mat, int row, int col,int[][] dp) {
        int n = mat.length;
        if (col < 0 || col >= n)
            return (int)1e9;

        if (row == n - 1)
            return mat[row][col];
        if(dp[row][col]!=-101) return dp[row][col];

        int down = f(mat, row + 1, col,dp);
        int left = f(mat, row + 1, col - 1,dp);
        int right = f(mat, row + 1, col + 1,dp);

        return dp[row][col] = mat[row][col] + Math.min(down, Math.min(left, right));
    }
}