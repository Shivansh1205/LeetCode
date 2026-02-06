// class Solution {
//     public int minDistance(String word1, String word2) {
//         int [][] dp = new int[word1.length()][word2.length()];
//         for(int[] a : dp) Arrays.fill(a,-1);
//         int k = f(word1,word2,word1.length()-1,word2.length()-1,dp);
//         int ans = (word1.length() - k + word2.length()-k);
//         return ans;
//     }
//     private int f(String s1,String s2, int n,int m,int[][] dp){
//         if(n<0 || m<0 ) return 0;
//         if(dp[n][m]!=-1) return dp[n][m];
//         if(s1.charAt(n) == s2.charAt(m)) return dp[n][m] = 1+f(s1,s2,n-1,m-1,dp);
//         return dp[n][m]=Math.max(f(s1,s2,n-1,m,dp),f(s1,s2,n,m-1,dp));
//     }
// }
class Solution {
    public int minDistance(String word1, String word2) {
        int [][] dp = new int[word1.length()+1][word2.length()+1];
        // for(int[] a : dp) Arrays.fill(a,-1);
        for(int i=0;i<word1.length();i++) dp[i][0]=0;
        for(int i=0;i<word2.length();i++) dp[0][i] = 0;
        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int k = dp[word1.length()][word2.length()];
        int ans = (word1.length() - k + word2.length()-k);
        return ans;
    }
}