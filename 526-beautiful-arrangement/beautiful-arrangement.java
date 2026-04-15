class Solution {
    public int countArrangement(int n) {
        boolean[] used = new boolean[n + 1];
        return f(n, 1, used);
    }

    private int f(int n, int pos, boolean[] used) {
        if (pos > n) return 1;

        int count = 0;

        for (int num = 1; num <= n; num++) {
            if (!used[num] && (num % pos == 0 || pos % num == 0)) {
                used[num] = true;
                count += f(n, pos + 1, used);
                used[num] = false;
            }
        }

        return count;
    }
}