class Solution {
    public int finalElement(int[] nums) {
        int ans = Math.max(nums[0],nums[nums.length-1]);
        return ans;
    }
}