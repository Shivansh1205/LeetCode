class Solution {
        public int countMagicalPairs(String s) {
        int n = s.length();
        int[][] L = new int[n][27];
        int[][] R = new int[n][27];
        int[] pos = new int[26];

        Arrays.fill(pos, -1);
        for (int i = 0; i < n; i++) {
            pos[s.charAt(i) - 'a'] = i;
            int[] p = new int[26];
            int sz = 0;
            for (int x : pos) if (x != -1) p[sz++] = x;
            Arrays.sort(p, 0, sz);
            for (int k = 0; k < sz; k++) {
                L[i][k + 1] = p[sz - 1 - k] - (k + 1 < sz ? p[sz - 2 - k] : -1);
            }
        }

        Arrays.fill(pos, n);
        for (int i = n - 1; i >= 0; i--) {
            pos[s.charAt(i) - 'a'] = i;
            int[] q = new int[26];
            int sz = 0;
            for (int x : pos) if (x != n) q[sz++] = x;
            Arrays.sort(q, 0, sz);
            for (int k = 0; k < sz; k++) {
                R[i][k + 1] = (k + 1 < sz ? q[k + 1] : n) - q[k];
            }
        }

        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int k = 1; k <= 26; k++) {
                res += L[i][k] * R[i + 1][k];
            }
        }
        return res;
    }
}