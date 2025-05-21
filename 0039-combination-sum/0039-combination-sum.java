class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        int n = arr.length;
        List<List<Integer>> res = new ArrayList();
        candi(0,res,new ArrayList<>(),n,arr,target,0);
        return res;
        
    }
    public void candi(int ind,List<List<Integer>> res, List<Integer> current, int n, int[] arr,int target,int sum){
        if(sum == target){
            res.add(new ArrayList<>(current));
            return;
        }
        if (sum > target || ind >= n) {
            return;
        }
        current.add(arr[ind]);
        candi(ind,res,current,n,arr,target,sum+arr[ind]);
        current.remove(current.size()-1);
        candi(ind+1,res,current,n,arr,target,sum);

        
    }
}