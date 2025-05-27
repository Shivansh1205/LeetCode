class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList();
        int [] arr = new int[9];
        for(int i =1 ; i<=9;i++){
            arr[i-1] = i;
        }
        
        backtrack(k,n,res,new ArrayList<>(),arr,0);
        return res;
    }
    public void backtrack(int k,int n, List<List<Integer>> res, List<Integer> cur,int [] arr,int start){
        if(n==0 && cur.size() == k){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = start;i<arr.length;i++){
            if (i > start && arr[i] == arr[i - 1]) continue;
            if(arr[i]>n) break;
            cur.add(i+1);
            backtrack(k,n-arr[i],res,cur,arr,i+1);
            cur.remove(cur.size()-1);
        }
    }

}