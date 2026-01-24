class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j = nums.length-1;
        int maxi = (int)(-1e8);
        while(i<=j){
            maxi = Math.max(maxi,nums[i]+nums[j]);
            i++;
            j--;
        }
        return maxi;
    }
}