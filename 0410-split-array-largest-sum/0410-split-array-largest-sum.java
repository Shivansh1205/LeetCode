class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int low = Integer.MIN_VALUE;
        int high =0;
        for(int i =0 ; i<n;i++){
            high += nums[i];
            low = Math.max(low,nums[i]);
        }
        while(low<=high){
            int mid = (low+high)/2;
            if(possible(nums,mid)<k){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public int possible(int [] nums, int d){
        int n = nums.length;
        int total =0 ;
        int ways =0; 
        for(int i =0 ; i<n ; i++){
            if(total+nums[i]<=d){
                total+=nums[i];
            }else{
                ways++;
                total = nums[i];
            }
        }
        return ways;
    }
}