class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums= new int[9];
        for(int i=0;i<9;i++){
            nums[i] = i+1;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        f(nums,k,n,res,cur,0);
        return res;
    }
    private void f(int[] nums, int k, int n, List<List<Integer>> res, List<Integer> cur, int idx){
        if(n==0 && k==0){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(idx == nums.length) return;
        for(int i=idx;i<nums.length;i++){
            //if (i > idx && nums[i] == nums[i - 1]) continue;

            if (nums[i] > n) break; // pruning

            cur.add(nums[i]);
            f(nums,k-1,n-nums[i],res,cur,i+1);
            cur.remove(cur.size()-1);
            // f(nums,k,n,res,cur,idx+1);
        }    
    }
}