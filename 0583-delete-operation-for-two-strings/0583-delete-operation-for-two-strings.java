class Solution {
    public int minDistance(String word1, String word2) {
        Integer[][] dp = new Integer[word1.length()+1][word2.length()+1];
        int ans = lcs(word1,word2,word1.length(),word2.length(),dp);
        return (word1.length()+word2.length()-2*ans);

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