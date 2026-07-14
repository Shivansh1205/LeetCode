class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Integer [][] dp = new Integer[triangle.size()][triangle.get(triangle.size()-1).size()];
        int ans = f(triangle, 0,0,dp);
        return ans;
    }
    private int f(List<List<Integer>> tri, int i, int j,Integer[][] dp){
        if(i>=tri.size() || j>=tri.get(tri.size()-1).size()) return 0;
        if(dp[i][j] != null) return dp[i][j];
        if(i == tri.size()-1){
            int mini = Integer.MAX_VALUE;

            mini = Math.min(mini, tri.get(i).get(j));
            return mini;
        }
        int mini = Integer.MAX_VALUE;
        int sum = tri.get(i).get(j) + f(tri,i+1,j,dp);

        int sum2 = tri.get(i).get(j) + f(tri,i+1,j+1,dp);
        mini = Math.min(mini, Math.min(sum,sum2));
        return dp[i][j] = mini;
    }
}