class Solution {
    public long countPairs(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String w : words) {
            String key = build(w);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        long ans = 0;
        for (int c : map.values()) {
            ans += (long) c * (c - 1) / 2;
        }
        return ans;
    }

    private String build(String w) {
        StringBuilder sb = new StringBuilder();
        int base = w.charAt(0) - 'a';

        for (int i = 0; i < w.length(); i++) {
            int cur = w.charAt(i) - 'a';
            int diff = (cur - base + 26) % 26;
            sb.append(diff);
        }

        return sb.toString();
    }
}
