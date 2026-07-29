class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] dp = new Integer[text1.length()+1][text2.length()+1];
        int ans  = f(text1,text2,text1.length(), text2.length(),dp);
        return ans;
        // StringBuilder sb = new StringBuilder();
        // while(i>=0 && j>=0){
        //         if(text1.charAt(i-1) == text2.charAt(j-1)){
        //             sb.append(text1.charAt(i-1))

        //         }else if(dp[i-1][j] >= dp[j-1][i]){
        //             i--;
        //         }else j--;
        // }
        
    }
    private int f(String s1, String s2, int i, int j,Integer[][] dp){
        if(i<=0 || j<=0) return 0;
        if(dp[i][j] != null) return dp[i][j];
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            dp[i][j] = 1 + f(s1,s2,i-1,j-1,dp);
        }
        else{
            dp[i][j] = Math.max(f(s1,s2,i-1,j,dp),f(s1,s2,i,j-1,dp));
        }
        return (int)dp[i][j];
    }   
}