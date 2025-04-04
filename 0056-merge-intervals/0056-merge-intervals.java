class Solution {
    public int[][] merge(int[][] nums) {
        Arrays.sort(nums, (a, b) -> Integer.compare(a[0], b[0]));
        int n = nums.length;
        List<int[]> ans = new ArrayList<>();
        int[] current = nums[0];
        for(int i =1; i< n; i++){
            if(current[1]>=nums[i][0]){
                current[1] = Math.max(current[1],nums[i][1]);
            }
            else{
                ans.add(current);
                current = nums[i];
            }
        }
        ans.add(current);
        return ans.toArray(new int[ans.size()][]);
        

    }
    

}