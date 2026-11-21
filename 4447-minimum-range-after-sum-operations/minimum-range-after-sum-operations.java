class Solution {
    private int gcd(int u, int v) {
        u = Math.abs(u);
        v = Math.abs(v);
        while (v != 0) {
            int t = u % v;
            u = v;
            v = t;
        }
        return u;
    }

    private int f(int u, int v) {
        return (1L * u * v < 0) ? gcd(u, v) : Math.max(Math.abs(u), Math.abs(v));
    }

    public int minRange(int a, int b, int c) {
        int initialRange = Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c));
        return Math.min(
            Math.min(initialRange, f(a, b)),
            Math.min(f(a, c), f(b, c))
        );
    }
}