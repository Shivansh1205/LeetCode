class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if(n<4)return false;
        int i=0;
        while(i<n-1 && nums[i]<nums[i+1])i++;
        if(i==0) return false;
        int dec = i;
        while(i<n-1 && nums[i]>nums[i+1])i++;
        if(i==dec) return false;
        dec = i;
        while(i<n-1 && nums[i]<nums[i+1])i++;
        if(i==dec) return false;
        return i == n-1;
    }
}