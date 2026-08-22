class Solution {
    public int minOperations(String s) {

        int n = s.length();
        int res = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){

            int x = i;

            for(int j = 0; j < n / 2; j++){

                char a = s.charAt((j + i) % n);
                char b = s.charAt((n - 1 - j + i) % n);

                int c = (a - b + 26) % 26;
                int d = (b - a + 26) % 26;

                x += Math.min(c, d);
            }

            res = Math.min(res, x);
        }

        return res;
    }
}