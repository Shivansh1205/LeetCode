class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        f(nums,0,set);
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> it : set){
            res.add(new ArrayList<>(it) );
        }
        return res;

    }
    private void f(int[] nums, int i, HashSet<List<Integer>> set){
        if(i == nums.length){
            List<Integer> cur = new ArrayList<>();
            for(int x : nums){
                cur.add(x);
            }
            set.add(new ArrayList<>(cur));
        }
        for(int j=i;j<nums.length;j++){
            swap(nums,i,j);
            f(nums,i+1,set);
            swap(nums,i,j);
        }

    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}