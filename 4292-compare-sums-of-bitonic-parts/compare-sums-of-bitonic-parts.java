class Solution {
    public int compareBitonicSums(int[] nums) {
        long asc =0;
        long desc =0;
        int cnt=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]) {
                cnt= Math.max(cnt,i+1);
                asc+=nums[i];
            }
            else if(nums[i]>nums[i+1]) desc+=nums[i];
        }
        asc+= nums[cnt];
        desc+=nums[nums.length-1];
        if(asc>desc) return 0;
        else if(desc>asc) return 1;
        else return -1;

    }
}