class Solution {
    private static final int INF = 100_000_000;

    private int[][] build(int[] b, int m) {
        int n = b.length;
        int[][] f = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            f[i][0] = INF;
            for (int v = 1; v <= m; v++) {
                int prev = (i > 0) ? f[i - 1][v - 1] : 0;
                f[i][v] = Math.min(f[i][v - 1], prev + Math.abs(b[i] - v));
            }
        }
        return f;
    }

    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return -1;
        }

        int maxVal = 0;
        for (int x : nums) {
            maxVal = Math.max(maxVal, x);
        }
        int m = maxVal + n;

        int[] rev = new int[n];
        for (int i = 0; i < n; i++) {
            rev[i] = nums[n - 1 - i];
        }

        int[][] l = build(nums, m);
        int[][] r = build(rev, m);

        int ans = INF;
        for (int i = 1; i < n - 1; i++) {
            for (int v = 1; v <= m; v++) {
                ans = Math.min(ans, l[i - 1][v - 1] + r[n - 2 - i][v - 1] + Math.abs(nums[i] - v));
            }
        }
        return ans;
    }
}