class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.computeIfAbsent(nums[i],k-> new ArrayList<>()).add(i);
        }
        int ans = Integer.MAX_VALUE;
        for(List<Integer> idx : map.values()){
            if(idx.size() >=3){
                for(int j=2;j<idx.size();j++){
                    int dis = 2*(idx.get(j)-idx.get(j-2));
                    ans = Math.min(ans,dis);
                }
                
            }
        }
        return ans == Integer.MAX_VALUE?-1:ans;
    }
}