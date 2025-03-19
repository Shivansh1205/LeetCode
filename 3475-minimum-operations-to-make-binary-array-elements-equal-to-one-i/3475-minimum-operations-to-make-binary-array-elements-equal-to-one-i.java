class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int cnt =0;
        for(int i =0; i<n-2;i++){
            if (nums[i]==0){
               flip(nums,i);
                flip(nums,i+1);
                flip(nums,i+2);
               cnt+=1;
            }
        }
        return (nums[n - 1] == 1 && nums[n - 2] == 1) ? cnt : -1;
    }
    public void flip(int[] nums, int i){
        if(i<nums.length){
            if (nums[i] ==0){
                nums[i] =1;
            }
            else{
                nums[i]=0;
            }
        }
    }
}