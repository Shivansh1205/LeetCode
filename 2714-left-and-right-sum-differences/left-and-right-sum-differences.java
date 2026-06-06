class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] ans = new int[nums.length];
        int sum =0;
        int left=0;
        for(int x : nums) sum+=x;
        for(int i=0;i<nums.length;i++){
            int r = sum-nums[i]-left;
            ans[i] = Math.abs(left-sum+nums[i]+left);
            left += nums[i];
        }
        return ans;
    }
}