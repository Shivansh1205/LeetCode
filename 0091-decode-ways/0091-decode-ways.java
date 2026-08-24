class Solution {
    public int numDecodings(String s) {
        Integer[] dp = new Integer[s.length()+1];
        int ans = f(0,s,dp);
        return ans;
    }
    private int f(int p, String s,Integer[]  dp){
        if(p == s.length()) return 1;
        if(s.charAt(p) =='0') return 0;
        if(dp[p]!=null) return dp[p];
        int res = f(p+1,s,dp);
        if(p+1<s.length()){
            if(s.charAt(p) == '1' || s.charAt(p) == '2' && s.charAt(p+1)<'7'){
                res+= f(p+2,s,dp);
            }
        }
        return dp[p] = res;
    }
}