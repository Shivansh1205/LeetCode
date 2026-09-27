class Solution {
    private boolean isInvalid(int[] p, int x) {
        // if I add x, will my subarray be valid or not? 
        for(int d = 1; d <= 500; d++) {
            if(p[d] == 0) continue; 
            // if x is sum a + b = x 
            int other = x - d; 
            if(other >= 0 && other <= 500) {
                // other valid
                if(other == d && p[d] >= 2) return true; 
                if(other != d && p[other] > 0) return true; 
            }


            // if x is one of value, a + x = b
            int t = x + d; 
            if(t >= 0 && t <= 500) {
                if(p[t] > 0) return true; 
            }
        }
        return false; 
    }
    public int maxSubarray(int[] nums) {
        // pair sum should be btw [0, 500] for to be valid. 

        // Starting from and start index `l` we can find till when we have valid pair. 
        // If we get a invalid pair after adding some index r, then subsequent arrays are not valid. that means move `l` now and again find till it's valid. 
        int l = 0, r = 0; 
        int n = nums.length; 
        int ans = 0; 
        int p[] = new int[501]; 
        
        for(int i = 0; i < n; i++) {
            while(l < i && isInvalid(p, nums[i])) {
                p[nums[l]]--; 
                l++; 
            }
            p[nums[i]]++; 
            ans = Math.max(ans, i - l + 1); 
        }
    
        return ans; 
    }
}