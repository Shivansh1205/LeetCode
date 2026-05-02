class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n = matrix.length;
        int[] ans= new int[n];
        int k=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] ==1) k++;
            }
            ans[i] =k;
            k=0;
        }
        return ans;
    }
}