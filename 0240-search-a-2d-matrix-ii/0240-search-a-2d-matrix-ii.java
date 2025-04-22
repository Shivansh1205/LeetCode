class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low=0;
        int high = m-1;
        while(low<n && high>=0){
            if(target == matrix[low][high]) return true;
            else if(target<matrix[low][high]) high--;
            else low++;
            }
            return false;
    }
}