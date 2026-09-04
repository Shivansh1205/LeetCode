class Solution {
    public int countSpecialIntegers(int[] nums) {
        int n = nums.length;
        int res=0;
        int[] cnt = new int[101];
        cnt[nums[0]]++;
        for(int i=1;i<n;i++){
            if(nums[i-1] != nums[i]){
                cnt[nums[i]]++;
            }
        }
        for(int i=0;i<cnt.length;i++){
            if(cnt[i] ==1) res++;
        }
        return res;
    }
}