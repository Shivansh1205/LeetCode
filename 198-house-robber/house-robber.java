class Solution {
    public int rob(int[] nums) {
        int n  =nums.length;
        int[] dp  =new int[n+1];
        dp[0] = nums[0];
        for(int i=1;i<n;i++){
            int pick = nums[i];
            if(i>1) pick+=dp[i-2];
            int notpick = dp[i-1];
            dp[i] = Math.max(pick,notpick);
        }
        return dp[n-1];
        
    }
//     private int f(int n, int[] nums,int[] dp){
//         if(n==0) return nums[n];
//         if(n<=0) return 0;
//         if(dp[n]!=-1) return dp[n];
//         int pick = nums[n]+f(n-2,nums,dp);
//         int notpick = 0+f(n-1,nums,dp);
//         return dp[n] = Math.max(pick,notpick);
//     }
// }
}