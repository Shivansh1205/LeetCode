class Solution {
    public int maximumJumps(int[] nums, int target) {
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-2);
        int ans = f(nums,target, 0, dp);
        return ans == Integer.MIN_VALUE?-1:ans;
    }

    private int f(int[] nums, int target, int idx, int[] dp){
        if(idx == nums.length-1) return 0;
        int maxi = Integer.MIN_VALUE;
        if(dp[idx]!=-2) return dp[idx];
        for(int j = idx+1; j<nums.length;j++){
            int diff = nums[j]-nums[idx];
            if(diff>= -target && diff<=target){
                int next = f(nums,target,j, dp);
                if(next!=Integer.MIN_VALUE)
                    maxi = Math.max(next+1,maxi);
            }
        }
        return dp[idx] = maxi;
    }
}