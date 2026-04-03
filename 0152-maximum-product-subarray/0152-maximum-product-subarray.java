class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int mini = nums[0];
        int maxi = nums[0];
        for(int i=1;i<nums.length; i++){
            int curr = nums[i];
            if(curr<0){
                int temp = maxi;
                maxi = mini;
                mini = temp;
            }
            maxi = Math.max(curr,maxi*curr);
            mini = Math.min(curr,mini*curr);
            res = Math.max(res,maxi);

        }
        return res;
    }
}