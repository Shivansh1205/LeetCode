class Solution {
    public int longestPalindromeSubseq(String s) {
        Integer[][] dp = new Integer[s.length()+1][s.length()+1];
        StringBuilder sb = new StringBuilder(s);
        String s2 = sb.reverse().toString();
        int ans = lcs(s,s2,s.length(),s.length(),dp);
        return ans ;
    }
    private int lcs(String s1, String s2, int i, int j,Integer[][] dp){
        if(i==0 || j==0) return 0;
        if(dp[i][j]!=null)return (int)dp[i][j];
        int cnt =0;
        int other =0;
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            cnt= 1 + lcs(s1,s2,i-1,j-1,dp);
        }

        else{
            int left = lcs(s1,s2,i-1,j,dp);
            int right = lcs(s1,s2,i,j-1,dp);
            other = Math.max(left,right);
        }
        return dp[i][j]= Math.max(cnt,other);
    }
}