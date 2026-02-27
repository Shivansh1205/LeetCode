class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            Set<Integer> st = new HashSet<>();
            for(int j=i+1;j<nums.length;j++){
                int third = -(nums[i]+nums[j]);
                if(st.contains(third)){
                    Integer[] ar= {nums[i],nums[j],third};
                    List<Integer> lis = Arrays.asList(ar);
                    Collections.sort(lis);
                    ans.add(lis);
                }
                st.add(nums[j]);
            }
        }
        return new ArrayList<>(ans);
    }
}