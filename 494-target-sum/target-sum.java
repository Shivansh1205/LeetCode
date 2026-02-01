class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int ans = f(nums, target,nums.length-1);
        return ans;
    }
    private int f(int[] nums, int target, int idx){
        if(idx<=0){
            if(target==0 && nums[0] == 0) return 2;
            if(Math.abs(target) == Math.abs(nums[0])) return 1;
            return 0;
        }
        int add = f(nums, target-nums[idx],idx-1);
        int sub = f(nums,target+nums[idx],idx-1);
        return add+sub;
    }
}