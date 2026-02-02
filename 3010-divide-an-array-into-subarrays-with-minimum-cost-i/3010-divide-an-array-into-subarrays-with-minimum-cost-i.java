class Solution {
    public int minimumCost(int[] nums) {
        int cost = nums[0];
        int mini1 = 100;
        int mini2 = 100;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<mini1){
                mini2 = mini1;
                mini1 = Math.min(mini1,nums[i]);
            }else if(nums[i]<mini2){
                mini2 = nums[i];
            }
        }
        cost += mini1+mini2;
        return cost;
    }
}