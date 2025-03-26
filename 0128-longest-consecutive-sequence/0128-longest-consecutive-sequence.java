class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); 
        if (n==0) return 0;
        int cnt =1;
        int longest = 1;
        for(int i =1; i<n;i++){
            if(nums[i] == nums[i-1] ){
                continue;
            }
            if(nums[i]-1 == nums[i-1] ){
                cnt++;
            }
            
            else{
                longest = Math.max(longest,cnt);
                cnt=1;
            }

        }
        longest = Math.max(longest,cnt);
        return longest;

    }
}