class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1]; // dp[i] = max points starting from question i

        for (int i = n - 1; i >= 0; --i) {
            int points = questions[i][0];
            int skip = questions[i][1];

            int nextIndex = i + skip + 1;
            long take = points + (nextIndex < n ? dp[nextIndex] : 0);
            long skipCurrent = dp[i + 1];

            dp[i] = Math.max(take, skipCurrent);
        }

        return dp[0];
    }
}
