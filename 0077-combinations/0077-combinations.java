class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = i+1;
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        f(nums, n, k, ans,list,0);
        return ans;
    }
    private void f(int[] nums, int n, int k, List<List<Integer>> ans, List<Integer> list,int idx){
        //if(idx == nums.length){
            if(k==0){
                ans.add(new ArrayList<>(list));
                return;
            }
            if(idx == nums.length) return;
        //}
        if(k>0){
            list.add(nums[idx]);
            f(nums,n,k-1,ans,list,idx+1);
            list.remove(list.size()-1);
        }
        f(nums,n,k,ans,list,idx+1);
    }
}