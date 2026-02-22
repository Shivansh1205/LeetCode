class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] dp =new int[nums.length];
        int[] prev = new int[nums.length];
        Arrays.sort(nums);
        Arrays.fill(dp,1);
        Arrays.fill(prev,-1);
        int maxi=0,maxind=-1;
        for(int i =0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;
                    prev[i] =j;
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
                maxind=i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int cur = maxind;
        while(cur!=-1){
            ans.add(nums[cur]);
            cur = prev[cur];
        }
        return ans;
    }
}