class Solution {
    public long minArraySum(int[] nums) {
        final int maxi = (int)1e5;
        boolean[] exists = new boolean[maxi+1];
        for(int x : nums){
            exists[x] = true;
        }
        long ans = 0;
        for(int x : nums){
            int best = x;
            for(int d=1;1L*d*d<=x;d++){
                if(x%d==0){
                    if(exists[d]){
                        best = d;
                        break;
                    }
                    int other = x/d;
                    if(exists[other]){
                        best = Math.min(best,other);
                    }
                }
            }
            ans += best;
        }
        return ans;
    }
}