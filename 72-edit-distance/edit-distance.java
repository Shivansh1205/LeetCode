class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for(int[] a: dp){
            Arrays.fill(a,-1);
        }
        return f(word1,word2,n-1,m-1,dp);
    }
    private int f(String s1, String s2, int i, int j, int[][] dp){
        if(i<0) return ++j;
        if(j<0) return ++i;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = f(s1,s2,i-1,j-1,dp);
        else{
            dp[i][j] = 1+Math.min(f(s1,s2,i-1,j-1,dp),Math.min(f(s1,s2,i-1,j,dp),f(s1,s2,i,j-1,dp)));
        }
        return dp[i][j];
    }
}