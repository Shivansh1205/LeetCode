class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // ✅ important
        List<List<Integer>> res = new ArrayList<>();
        f(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void f(int[] nums, int idx, List<Integer> cur, List<List<Integer>> res) {
        res.add(new ArrayList<>(cur));

        for (int i = idx; i < nums.length; i++) {
            // 🔥 skip duplicates at same level
            if (i > idx && nums[i] == nums[i - 1]) continue;

            cur.add(nums[i]);
            f(nums, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}