class Solution {
    public int nthUglyNumber(int n) {

        int[] t = new int[n + 1];

        t[1] = 1;

        int i1 = 1, i2 = 1, i3 = 1;

        for (int i = 2; i <= n; i++) {

            int i1u = t[i1] * 2;
            int i2u = t[i2] * 3;
            int i3u = t[i3] * 5;

            int mini = Math.min(i1u, Math.min(i2u, i3u));

            t[i] = mini;

            if (mini == i1u) i1++;
            if (mini == i2u) i2++;
            if (mini == i3u) i3++;
        }

        return t[n];
    }
}