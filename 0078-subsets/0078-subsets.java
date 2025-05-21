class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList();
        powerset(n,res,new ArrayList<>(),nums,0);
        return res;
    }
    public void powerset(int n, List<List<Integer>> res,List<Integer> current,int [] nums,int ind){
            if (ind >= n) {
            res.add(new ArrayList<>(current));
            return;
        }
            current.add(nums[ind]);
            powerset(n,res,current,nums,ind+1);
            current.remove(current.size()-1);
            powerset(n,res,current,nums,ind+1);

            
    }
}
