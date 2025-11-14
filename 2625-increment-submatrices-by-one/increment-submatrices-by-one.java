class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] v = new int[n][n];

        for (int i = 0; i < queries.length; i++) {
            int r1 = queries[i][0];
            int r2 = queries[i][2];
            int c1 = queries[i][1];
            int c2 = queries[i][3];

            for (int j = r1; j <= r2; j++) {
                v[j][c1]++;

                if (c2 + 1 != n) {
                    v[j][c2 + 1]--;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                v[i][j] += v[i][j - 1];
            }
        }

        return v;
    }
}
