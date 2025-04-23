class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0, high = m - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int row = findRow(mat, n, mid);


            boolean leftSmaller = (mid == 0 || mat[row][mid] > mat[row][mid - 1]);
            boolean rightSmaller = (mid == m - 1 || mat[row][mid] > mat[row][mid + 1]);

            if (leftSmaller && rightSmaller) {
                return new int[]{row, mid};  
            } else if (mid < m - 1 && mat[row][mid + 1] > mat[row][mid]) {
                low = mid + 1;  
            } else {
                high = mid - 1; 
            }
        }

        return new int[]{-1, -1};  
    }

    private int findRow(int[][] mat, int n, int col) {
        int maxRow = 0;
        for (int i = 1; i < n; i++) {
            if (mat[i][col] > mat[maxRow][col]) {
                maxRow = i;
            }
        }
        return maxRow;
    }
}
