class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        List<Integer>[] pos = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            pos[i] = new ArrayList<>();
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int num = nums[i];
            pos[num].add(i);
            if(pos[num].size()>3){
                pos[num].remove(0);
            }
            if(pos[num].size()==3){
                int first = pos[num].get(0);
                int last = pos[num].get(2);
                int dist = 2*(last-first);
                ans = Math.min(ans,dist);
            }
        }
        return ans == Integer.MAX_VALUE?-1:ans;
    }
}