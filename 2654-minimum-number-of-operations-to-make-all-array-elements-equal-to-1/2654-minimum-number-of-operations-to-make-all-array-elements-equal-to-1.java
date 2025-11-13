class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int one=0;
        for(int i=0;i<n;i++){
            if(nums[i] ==1) one++;
        }
        if(one>0) return n-one;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            int g = nums[i];
            for(int j=i+1;j<n;j++){
                g = gcd(g,nums[j]);
                if(g == 1){
                    ans = Math.min(ans,j-i);
                    break;
                }
            }
        }
        if(ans == Integer.MAX_VALUE) return -1;
        return ans +(n-1);
    }
    private int gcd(int a,int b){
        while(b!=0){
            int t = b;
            b = a%b;
            a=t;
        }
        return a;
    }
}