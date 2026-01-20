// class Solution {
//     public boolean canPartition(int[] nums) {
//         int sum=0;
//         for(int i=0;i<nums.length;i++){
//             sum+=nums[i];
//         }
//         if(sum%2==1)return false;
//         int[][] dp = new int[nums.length][sum];
//         for(int[] a: dp){
//             Arrays.fill(a,-1);
//         }
//         return f(nums,nums.length-1,sum/2,dp);
//     }
//     private boolean f(int[] nums, int idx, int sum, int[][] dp){
//         if(sum == 0 )return true;
//         if(idx==0) return (nums[0] == sum);
//         if(dp[idx][sum]!=-1) return dp[idx][sum]==1;
//         boolean nt = f(nums,idx-1,sum,dp);
//         boolean t = false;
//         if(sum>=nums[idx]){
//             t = f(nums, idx-1,sum-nums[idx],dp);
//         }
//         dp[idx][sum] = t||nt?1:0;
//         return t||nt;
//     }
// }
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2==1)return false;
        int target = sum/2;
        int[][] dp = new int[nums.length][target+1];
        // for(int[] a: dp){
        //     Arrays.fill(a,0);
        // }
        for(int i=0;i<nums.length;i++) dp[i][0] =1;
        if(target>=nums[0])dp[0][nums[0]] =1;
        for(int idx=1;idx<nums.length;idx++){
            for(int j=0;j<=target;j++){
                boolean nt = dp[idx-1][j]==1;
                boolean t = false;
                if(j>=nums[idx]){
                    t = dp[idx-1][j-nums[idx]]==1;
                }
                dp[idx][j] = t||nt?1:0;
            }
        }
        return dp[nums.length-1][target]==1;
    }
}