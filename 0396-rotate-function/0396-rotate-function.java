class Solution {
    public int maxRotateFunction(int[] nums) {
        int n= nums.length;
        int f = 0;
        int sum =0;
        for(int i=0;i<nums.length;i++){
            f+=i*nums[i];
            sum+=nums[i];
        }
        int maxi = f;
        for(int i=1;i<nums.length;i++){
            f+= sum-nums[n-i]*n;
            maxi = Math.max(maxi,f);
        }
        return maxi;
        
    }
}