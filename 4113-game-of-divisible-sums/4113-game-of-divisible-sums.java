class Solution {
    int n; int nums[];
    long dp[];
    public long helper(int idx){
 
        if(idx == n){
            return 0;
        }

        if(dp[idx] != -1) return dp[idx];

        long max = 0;
        if(idx+2 <= n){
            int sum =nums[idx] + nums[idx+1];
            if((sum % 3) == 0){
                max = sum - helper(idx+2);
            }else{
                max = sum + helper(idx+2);
            }
        }
        if(nums[idx] % 3 == 0){
            max = Math.max(max, nums[idx] - helper(idx+1));
        }else{
            max = Math.max(max, nums[idx] + helper(idx+1));
        }
        

        return dp[idx] = max;
    }
    public long maxDifference(int[] nums) {
        n = nums.length;        
        this.nums = nums;
        dp = new long[n];
        Arrays.fill(dp , -1);

        return helper(0);
    }
}