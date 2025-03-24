class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i =0;
        int j =0;
        for(i = 1; i<n; i++){
            if(nums[j]!=0 && nums[i] ==0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
            if(nums[j] ==0){
                j++;
            }
        }
        for(i=j+1; i<n;i++){
            if(nums[j]==2 && nums[i] ==1){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
            if(nums[j] ==1){
                j++;
            }
        }
        
    }
}