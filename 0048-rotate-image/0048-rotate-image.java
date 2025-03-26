class Solution {
    public void rotate(int[][] nums) {
        int n = nums.length;
        int [][] arr = new int[nums.length][nums.length];
        for(int i =0; i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                arr[j][n-i-1] = nums[i][j]; 
            }
        }
        for(int i =0; i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                nums[i][j] = arr[i][j];

            }
        }
    }
}