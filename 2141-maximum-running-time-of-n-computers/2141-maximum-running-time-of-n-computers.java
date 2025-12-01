class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int b : batteries) sum += b;

        long left = 0, right = sum / n;

        while (left < right) {
            long mid = right - (right - left) / 2; // try a candidate time
            if (canRun(mid, batteries, n)) {
                left = mid;    // mid is possible, try longer
            } else {
                right = mid - 1; // mid not possible, try shorter
            }
        }

        return left;
    }

    private boolean canRun(long time, int[] batteries, int n) {
        long total = 0;
        for (int b : batteries) total += Math.min(b, time);
        return total >= time * n;
    }
}
