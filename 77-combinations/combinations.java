class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums= new int[n];
        for(int i=0;i<n;i++){
            nums[i] = i+1;
        }
        List<Integer> cur = new ArrayList<>();
        f(res,0,nums,k,cur);
        return res;
    }
    private void f(List<List<Integer>> res, int idx, int[] nums, int k, List<Integer> cur){
        if(k==0){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(idx == nums.length) return;
        if(k>0){
            int ele = nums[idx];
            cur.add(ele);
            f(res,idx+1,nums,k-1,cur);
            cur.remove(cur.size()-1);
        }
        f(res,idx+1,nums,k,cur);
    }
}