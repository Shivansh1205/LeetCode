class Solution {
    public int minDistance(String word1, String word2) {
        int [][] dp = new int[word1.length()][word2.length()];
        for(int[] a : dp) Arrays.fill(a,-1);
        int k = f(word1,word2,word1.length()-1,word2.length()-1,dp);
        int ans = (word1.length() - k + word2.length()-k);
        return ans;
    }
    private int f(String s1,String s2, int n,int m,int[][] dp){
        if(n<0 || m<0 ) return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        if(s1.charAt(n) == s2.charAt(m)) return dp[n][m] = 1+f(s1,s2,n-1,m-1,dp);
        return dp[n][m]=Math.max(f(s1,s2,n-1,m,dp),f(s1,s2,n,m-1,dp));
    }
}