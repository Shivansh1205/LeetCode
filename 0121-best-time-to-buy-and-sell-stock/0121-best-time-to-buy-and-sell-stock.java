class Solution {
    public int maxProfit(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int max = 0;
        for(int i=0;i<n;i++){
            if(nums[i]<min){
                min = nums[i];
            }
            int sum = nums[i]-min;
            if(max<sum){
                max = sum;
            }
        }
        return max;
    }
}