class Solution {
    public int countConsistent(int[] nums) {
        int consistent = 0;
        for (int i = 0; i < nums.length; i++) {
            int mini = Integer.MAX_VALUE, andVal = nums[i];
            for (int j = i; j < nums.length; j++) {
                mini = Math.min(nums[j], mini);
                andVal &= nums[j];
                if (andVal == mini)
                    consistent++;
            }
        }
        return consistent;
    }
}