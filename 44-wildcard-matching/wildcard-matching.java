class Solution {
  public boolean isMatch(String s, String p) {
    int n= s.length();
    int m = p.length();
    int[][] dp = new int[n][m];
    for(int[] a:dp) Arrays.fill(a,-1);
    return f(s,p,n-1,m-1,dp);
  }
  private boolean f(String s, String p, int i, int j, int[][]dp){
    if(i<0 && j<0) return true;
    if(j<0 && i>=0) return false;
    if(j>=0 && i<0) return f2(p,j);
    if(dp[i][j]!=-1) return dp[i][j]==1;
    if((s.charAt(i) == p.charAt(j)) || p.charAt(j) == '?') dp[i][j] = f(s,p,i-1,j-1,dp)?1:0;
    else if(p.charAt(j) == '*'){
        dp[i][j] = (f(s,p,i-1,j,dp)||f(s,p,i,j-1,dp))?1:0;
    } else dp[i][j]=0;
    return dp[i][j]==1;
  }
  private boolean f2(String p, int j){
    for(int i=0;i<=j;i++){
        if(p.charAt(i) !='*') return false;
    }
    return true;
  }
}
