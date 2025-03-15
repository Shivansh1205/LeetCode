class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0; // Edge case: Empty array

        int j = 1; // Index to track unique elements
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) { // Compare with previous element
                nums[j] = nums[i]; // Store unique element
                j++;
            }
        }

        return j; // Length of unique elements
    }
}
