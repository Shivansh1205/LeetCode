class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        f(candidates, target, res, cur, 0);
        return res;
    }

    private void f(int[] nums, int target, List<List<Integer>> res, List<Integer> cur, int idx) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;

            if (nums[i] > target) break;

            cur.add(nums[i]);
            f(nums, target - nums[i], res, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}