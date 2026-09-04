class Solution {
    public int minOperations(int[] nums, int sum) {
        final int INF = 1000000;
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int x : nums) {
            int[] next = dp.clone();
            long value = x;
            int cost = 0;

            while (value <= sum) {
                int v = (int) value;

                for (int s = v; s <= sum; s++) {
                    if (dp[s - v] != INF) {
                        next[s] = Math.min(next[s], dp[s - v] + cost);
                    }
                }

                value *= 2;
                cost++;
            }

            value = x;
            cost = 0;

            while (value > 1) {
                value /= 2;
                cost++;

                int v = (int) value;

                if (v == 0) {
                    break;
                }

                for (int s = v; s <= sum; s++) {
                    if (dp[s - v] != INF) {
                        next[s] = Math.min(next[s], dp[s - v] + cost);
                    }
                }
            }

            dp = next;
        }

        return dp[sum] == INF ? -1 : dp[sum];
    }
}