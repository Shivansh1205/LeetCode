class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {

        long[] t = new long[n + 1];
        int[] p = new int[primes.length];

        t[1] = 1;
        Arrays.fill(p, 1);

        for (int i = 2; i <= n; i++) {

            long mini = Long.MAX_VALUE;

            for (int j = 0; j < primes.length; j++) {
                long candidate = t[p[j]] * primes[j];
                mini = Math.min(mini, candidate);
            }

            t[i] = mini;

            for (int j = 0; j < primes.length; j++) {
                if (t[p[j]] * primes[j] == mini) {
                    p[j]++;
                }
            }
        }

        return (int) t[n];
    }
}