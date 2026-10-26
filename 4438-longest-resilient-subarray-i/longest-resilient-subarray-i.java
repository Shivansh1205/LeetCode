class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int n = nums.length, best = 0;
        for (int l = 0; l < n; l++) {
            int rem = nums[l] % k;
            long s = 0;
            for (int r = l; r < n; r++) {
                if (nums[r] % k != rem) break; 
                s += nums[r];
                if (s % k == rem) best = Math.max(best, r - l + 1);  
            }
        }
        return best;
    }
}