class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int j=0;
        int[] arr = new int[n];
        Arrays.fill(arr,0);
        for(int i =0 ;i<n;i++){
            if(nums[i]>0){
                arr[j] = nums[i];
                j+=2;
            }
        }
        j=1;
        for(int i =0 ;i<n;i++){
            if(nums[i]<0){
                arr[j] = nums[i];
                j+=2;
            }
        }

        return arr;
        
    }
}