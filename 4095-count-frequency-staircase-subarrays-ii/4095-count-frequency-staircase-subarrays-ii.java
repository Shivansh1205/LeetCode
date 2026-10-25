class Solution {
    public int countStaircase(int[] A) {
        int n = A.length;
        int[] ind = new int[n];
        Map<Integer, List<Integer>> pos = new HashMap<>();

        for (int i = 0; i < n; i++) {
            pos.putIfAbsent(A[i], new ArrayList<>());
            ind[i] = pos.get(A[i]).size();
            pos.get(A[i]).add(i);
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            int L = i;
            int R = n;
            for (int j = i; j < R; j++) {
                int a = A[j];
                if (seen.contains(a)) continue;
                seen.add(a);
                int k = seen.size();
                List<Integer> lst = pos.get(a);
                if (ind[j] + k - 1 >= lst.size()) {
                    break;
                }
                int L2 = lst.get(ind[j] + k - 1);
                int R2 = ind[j] + k < lst.size() ? lst.get(ind[j] + k) : n;
                L = Math.max(L, L2);
                R = Math.min(R, R2);
                if (L > R) {
                    break;
                }
                int end_idx = i + k * (k + 1) / 2 - 1;
                if (L <= end_idx && end_idx < R) {
                    res++;
                }
            }
        }
        return res;
    }
}