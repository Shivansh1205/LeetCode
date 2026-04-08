class Solution {
    public int xorAfterQueries(int[] nums, int[][] q) {
        for(int i =0; i<q.length;i++){
            final long mod = (int)1e9+7;
            int l = q[i][0],r=q[i][1],k=q[i][2],v=q[i][3];
            int idx = l;
            while(idx<=r){
                long temp = ((long)nums[idx]*(long)v)%mod;
                nums[idx] = (int)temp;
                idx+=k;
            }
            
        }
        int x = 0;
        for(int i=0; i<nums.length; i++){
            x^=nums[i];
        }
        return x;
    }
}