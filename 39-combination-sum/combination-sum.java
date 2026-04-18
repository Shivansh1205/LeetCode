class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        f(candidates, target,res,cur,0);
        return res;
    }
    private void f(int[] nums, int target, List<List<Integer>> res, List<Integer> cur, int idx){
        if(target==0){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        if(idx == nums.length) return;
        if(nums[idx]<=target){
            cur.add(nums[idx]);
            f(nums,target-nums[idx],res,cur,idx);
            cur.remove(cur.size()-1);
        }
        f(nums,target,res,cur,idx+1);
    }
}