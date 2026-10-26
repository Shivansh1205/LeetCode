class Solution {
    public int peakValleyDifference(int[] nums) {
        int peaks = 0 ;
        int val = 0;
        int n = nums.length;
        for(int i=1;i<n-1;i++){
            if(nums[i]>nums[i+1] && nums[i]>nums[i-1]) peaks += nums[i];
            if(nums[i]<nums[i+1] && nums[i]<nums[i-1]) val += nums[i];
        }
        return peaks -val;
    }
}