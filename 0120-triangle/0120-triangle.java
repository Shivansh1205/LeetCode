class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        for(int i=0;i<m;i++)
            for(int j=0;j<m;j++) dp[i][j] =-1;
        int ans = f(0,0,m-1,triangle,dp);
        return ans;
    }
    public int f(int i, int j, int n, List<List<Integer>> triangle,int[][] dp){
        if(i==n) return triangle.get(i).get(j);
        if(dp[i][j] !=-1) return dp[i][j];
        int d = triangle.get(i).get(j) + f(i+1,j,n,triangle,dp);
        int right = triangle.get(i).get(j) + f(i+1,j+1,n,triangle,dp);
        return dp[i][j] = Math.min(d,right); 
    }
}