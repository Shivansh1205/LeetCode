class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
            prefixMax[i] = maxi;
        }

        int mini = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            mini = Math.min(mini, nums[i]);
            suffixMin[i] = mini;
        }

        for (int i = 0; i < n; i++) {
            int score = prefixMax[i] - suffixMin[i];
            if (score <= k) return i;
        }

        return -1;
    }
}