class Solution {
    public boolean divideArray(int[] nums) {
        int n = nums.length;
        int [] arr = new int[501];
        for(int i =0;i<n;i++){
            arr[nums[i]]++;
        }
        for(int a : arr){
            if(a%2!=0){
                return false;
            }
        }
        return true;
        
    }
}