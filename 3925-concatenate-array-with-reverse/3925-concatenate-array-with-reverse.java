class Solution {
    public int[] concatWithReverse(int[] nums) {
        int[] ans = new int[2*nums.length];
        int i=0;
        int j=2*nums.length-1;
        while(i<=j){
            ans[i] = nums[i];
            ans[j] = nums[i];
            i++;
            j--;
        }
        return ans;
    }
}