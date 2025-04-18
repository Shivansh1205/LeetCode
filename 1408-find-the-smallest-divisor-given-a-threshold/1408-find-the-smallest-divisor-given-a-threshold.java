class Solution {
    public int smallestDivisor(int[] nums, int t) {
        int n = nums.length;
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for(int i =0; i<n ;i++){
            maxi = Math.max(nums[i], maxi);
        }
        int low = 1;
        int high = maxi ;
        while(low<=high){
            int mid = (low+high)/2;
            if(possible(nums,t,mid)){
                high = mid-1;
            }
            else{
                 low = mid+1;
            }
        }
        return low;
    }
    public boolean possible(int [] nums, int t, int m){
        int n = nums.length; 
        int total=0;
        for(int i = 0; i<n; i++){
            total+=(int)Math.ceil((double)nums[i] / m);
        }
        return total<=t;
    }
}