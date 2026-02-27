class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Set<List<Integer>> ans = new HashSet<>();
        // for(int i=0;i<nums.length;i++){
        //     Set<Integer> st = new HashSet<>();
        //     for(int j=i+1;j<nums.length;j++){
        //         int third = -(nums[i]+nums[j]);
        //         if(st.contains(third)){
        //             Integer[] ar= {nums[i],nums[j],third};
        //             List<Integer> lis = Arrays.asList(ar);
        //             Collections.sort(lis);
        //             ans.add(lis);
        //         }
        //         st.add(nums[j]);
        //     }
        // }
        // return new ArrayList<>(ans);

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            int l = i+1;
            int r = nums.length-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if(sum==0){
                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                    while(l<r && nums[l] == nums[l-1]) l++;
                    while(l<r && nums[r] == nums[r+1]) r--;
                }
                else if(sum>0) r--;
                else l++;
            }
        }
        return ans;
    }
}