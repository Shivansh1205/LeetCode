class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n-1;
        int mid = 0;
        if(target<nums[low]) return 0;
        while(high>=low){
            mid = (low+high)/2;
            if(target == nums[mid]) return mid;
            else if(target>nums[mid]) low = mid+1;
            else high = mid-1;
        }
        return high +1;
    }
}