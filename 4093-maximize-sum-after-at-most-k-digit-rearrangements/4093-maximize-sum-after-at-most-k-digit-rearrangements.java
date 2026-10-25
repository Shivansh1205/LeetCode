class Solution {
    public long maximizeSum(int[] nums, int k) {
        // Arrays.sort(nums);
        int n = nums.length;
        long ans =0;
        for(int i=0;i<nums.length;i++){
            ans += nums[i];
        }
        
        int gain[] = new int[n];
        for(int i=0;i<n;i++){
            gain[i] = perm(nums[i]) - nums[i];
        }
        Arrays.sort(gain);

for (int i = n - 1; i >= Math.max(0, n - k); i--) {
    if (gain[i] <= 0) break;
    ans += gain[i];
}
        return ans;

        
    }
    public int perm(int ele){
        char[] a = String.valueOf(ele).toCharArray();
        Arrays.sort(a);
        StringBuilder sb = new StringBuilder(new String(a));
        sb.reverse();
        return Integer.parseInt(sb.toString());
    }
}