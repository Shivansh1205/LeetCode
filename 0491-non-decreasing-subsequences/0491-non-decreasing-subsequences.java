class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        f(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    private void f(List<List<Integer>> ans, List<Integer> list, int[] nums, int idx) {
        
        if (list.size() >= 2) {
            ans.add(new ArrayList<>(list));
        }

        Set<Integer> used = new HashSet<>();

        for (int i = idx; i < nums.length; i++) {

            if (used.contains(nums[i])) continue;

            if (list.isEmpty() || nums[i] >= list.get(list.size() - 1)) {
                used.add(nums[i]);

                list.add(nums[i]);
                f(ans, list, nums, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}