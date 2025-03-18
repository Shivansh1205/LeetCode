class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0, bitwiseAnd = 0, maxLength = 0;
        
        for (int right = 0; right < nums.length; right++) {
            
            while ((bitwiseAnd & nums[right]) != 0) {
                bitwiseAnd ^= nums[left]; 
                left++; 
            }
            

            bitwiseAnd |= nums[right];
            

            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
