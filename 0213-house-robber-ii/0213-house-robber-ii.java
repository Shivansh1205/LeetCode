class Solution {
    public int rob(int[] nums) {
        if(nums.length ==1) return nums[0];
        if(nums.length==0) return 0;
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i!=0) arr1.add(nums[i]);
            if(i!=nums.length-1) arr2.add(nums[i]);
        }
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        int a1= f(arr1,0,dp);
        Arrays.fill(dp,-1);
        int a2 = f(arr2,0,dp);
        return Math.max(a1,a2);

    }
    private int f(List<Integer> nums, int i,int[] dp) {
        if (i >= nums.size())
            return 0;
        if(dp[i]!=-1) return dp[i];
        int rob = nums.get(i) + f(nums, i + 2,dp);
        int skip = f(nums, i + 1,dp);

        return dp[i]=Math.max(rob, skip);
    }
}