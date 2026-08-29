class Solution {
    public int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int ans = f(n,1);
        return ans;
    }
    private int f(int n, int i){
        if(n==0){
            return 1;
        }
        if(i>n) return Integer.MIN_VALUE;
        int p =-1;
        if(i<=n){
            p = i*f(n-i,i);
        }
        int np = f(n,i+1);
        return Math.max(p,np);
    }
}