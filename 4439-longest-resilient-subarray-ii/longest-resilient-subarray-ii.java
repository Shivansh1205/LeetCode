class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int n = nums.length, best = 0;
        for (int i = 0; i < n; ) {
            int rem = nums[i] % k, hand = 0, j = i;
            while (j < n && nums[j] % k == rem) { 
                j++;
                hand = (hand + rem) % k;  
                if (hand == rem) best = Math.max(best, j - i);  
            }
            i = j;
        }
        return best;
    }
}