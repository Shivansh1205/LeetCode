class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int[] a: dp){
            Arrays.fill(a,-1);
        }
        return helper(0,0,s,t,dp);
    }
    private int helper(int i, int j, String s, String t, int[][]dp){
        if(j==t.length()) return 1;
        if(i==s.length()) return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
            int ta = helper(i+1,j+1,s,t,dp);
            int nt = helper(i+1,j,s,t,dp);
            dp[i][j] = ta+nt;
        }else{
            dp[i][j] = helper(i+1,j,s,t,dp);
        }
        return dp[i][j];
    }
}