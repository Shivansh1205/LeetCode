class Solution {
    public int longestAlternating(int[] nums) {
        int n = nums.length;
        int max = 1;
        int[][] dp1 = new int[n][2];
        int[][] dp2 = new int[n][2];
        for(int[] a : dp1) Arrays.fill(a,1);
        for(int[] a : dp2) Arrays.fill(a,1);
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                dp1[i][1] = dp1[i-1][0]+1;
                max= Math.max(max,dp1[i][1]);
            }
            if(nums[i]<nums[i-1]){
                dp1[i][0] = dp1[i-1][1]+1;
                max= Math.max(max,dp1[i][0]);
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                dp2[i][1] = dp2[i + 1][0] + 1;
                max = Math.max(max, dp2[i][1]);
            }
            if (nums[i] < nums[i + 1]) {
                dp2[i][0] = dp2[i + 1][1] + 1;
                max = Math.max(max, dp2[i][0]);
            }
        }
        for(int i=1;i<n-1;i++){
            if(nums[i+1]>nums[i-1]){
                max = Math.max(max,dp1[i-1][0]+dp2[i+1][1]);
            }
            if(nums[i+1]<nums[i-1]){
                max = Math.max(max,dp1[i-1][1]+dp2[i+1][0]);
            }
        }
        return max;
    }
}
