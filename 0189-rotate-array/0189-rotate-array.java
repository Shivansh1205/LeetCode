class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n];
        int j = 0;
        if(k>n){
            k=(k-n)%n;
            k=n-k;
        }
        else{
            k=n-k;
        }
        for(int i = k; i<n; i++){
            arr[j] = nums[i];
            j++;
        }
        for(int i = 0 ; i<k;i++){
            arr[j] = nums[i];
            j++;
        }
        for(int i =0; i<n;i++){
            nums[i] = arr[i];
        }
    }
}