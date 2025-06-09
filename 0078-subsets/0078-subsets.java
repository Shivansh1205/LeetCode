class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int subsets = 1<<nums.length;
        List<List<Integer>> res = new ArrayList();
        for(int j =0; j<subsets;j++){
            List<Integer> list = new ArrayList();
            for(int i =0 ;i<nums.length;i++){
                if ((j & (1 << i)) != 0){
                    list.add(nums[i]);
                }

            }
            res.add(list);
        }
        return res;
    }
}
