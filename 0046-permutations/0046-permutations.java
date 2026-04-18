class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        f(nums,0,res);
        return res;
    }
    private void f(int[] nums, int i, List<List<Integer>> res){
        if(i==nums.length){
            List<Integer> cur = new ArrayList<>();
            for(int x: nums){
                cur.add(x);
            }
            res.add(new ArrayList<>(cur));
        }
        for(int j=i;j<nums.length;j++){
            swap(nums,i,j);
            f(nums,i+1,res);
            swap(nums,i,j);
        }
    }
    private void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}