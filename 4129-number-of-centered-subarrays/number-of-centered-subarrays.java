class Solution {
    public int centeredSubarrays(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            HashSet<Long> s = new HashSet<>();
            long sum = 0;  

            for (int j = i; j < n; j++) {
                sum += nums[j];
                s.add((long) nums[j]);

                if (s.contains(sum)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}