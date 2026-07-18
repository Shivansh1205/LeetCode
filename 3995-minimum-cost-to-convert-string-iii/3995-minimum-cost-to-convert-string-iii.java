class Solution {

    int[] dp;
    final int INF = Integer.MAX_VALUE;

    private int f(int i, String source, String target,
                  List<List<String>> rules, int[] costs) {

        if (i == source.length())
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int ans = INF;

        if (source.charAt(i) == target.charAt(i))
            ans = f(i + 1, source, target, rules, costs);

        for (int j = 0; j < rules.size(); j++) {

            String x = rules.get(j).get(0);
            String y = rules.get(j).get(1);

            if (i + x.length() > source.length())
                continue;

            boolean valid = true;
            int wildcard = 0;

            for (int k = 0; k < x.length(); k++) {

                if (x.charAt(k) != '*' &&
                    source.charAt(i + k) != x.charAt(k)) {
                    valid = false;
                    break;
                }

                if (x.charAt(k) == '*')
                    wildcard++;

                if (y.charAt(k) != target.charAt(i + k)) {
                    valid = false;
                    break;
                }
            }

            if (!valid)
                continue;

            int nxt = f(i + x.length(), source, target, rules, costs);

            if (nxt != INF)
                ans = Math.min(ans, costs[j] + wildcard + nxt);
        }

        return dp[i] = ans;
    }

    public int minCost(String source, String target,
                       List<List<String>> rules,
                       int[] costs) {

        dp = new int[source.length() + 1];
        Arrays.fill(dp, -1);

        int ans = f(0, source, target, rules, costs);

        return ans == INF ? -1 : ans;
    }
}