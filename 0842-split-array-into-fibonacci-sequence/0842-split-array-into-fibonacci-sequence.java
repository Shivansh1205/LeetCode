class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> ans = new ArrayList<>();
        f(num, ans, 0);
        return ans;
    }

    private boolean f(String num, List<Integer> ans, int idx) {
        if (idx == num.length()) return ans.size() >= 3;

        long n = 0;

        for (int i = idx; i < num.length(); i++) {

            // leading zero check
            if (i > idx && num.charAt(idx) == '0') break;

            n = n * 10 + (num.charAt(i) - '0');
            if (n > Integer.MAX_VALUE) break;

            int size = ans.size();

            if (size >= 2) {
                long sum = (long) ans.get(size - 1) + ans.get(size - 2);
                if (n > sum) break;
                if (n < sum) continue;
            }

            ans.add((int) n);

            if (f(num, ans, i + 1)) return true;

            ans.remove(ans.size() - 1);
        }

        return false;
    }
}