class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        f(candidates, target, ans, new ArrayList<Integer>() ,0);
        return ans;
    }
    private void f(int[] arr, int t, List<List<Integer>> ans , List<Integer> list,int idx){
        if(idx == arr.length){
            if (t ==0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        
        if(arr[idx]<=t){
            list.add(arr[idx]);
            f(arr,t-arr[idx],ans,list,idx);
            list.remove(list.size()-1);
        }
        f(arr,t,ans,list,idx+1);
    }
}