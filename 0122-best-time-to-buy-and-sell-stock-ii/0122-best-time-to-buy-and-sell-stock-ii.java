// class Solution {
//     public int maxProfit(int[] prices) {
//         int [][]dp = new int[prices.length+1][2];
       
//         for(int[] a:dp) Arrays.fill(a,-1); 
//         int ans = f(0,1,prices,dp);
//         return ans;
//     }
//     private int f(int ind, int buy,int[] a,int[][]dp){
//         if(ind==a.length) return 0;
//         if(dp[ind][buy]!=-1) return dp[ind][buy];
//         int profit=0;
//         if(buy==1){
//             profit = Math.max(-a[ind]+f(ind+1,0,a,dp),f(ind+1,1,a,dp));
//         }else{
//             profit = Math.max(a[ind]+f(ind+1,1,a,dp),f(ind+1,0,a,dp));
//         }
//         return dp[ind][buy]=profit;
//     }
// }
class Solution {
    public int maxProfit(int[] prices) {
        int [][]dp = new int[prices.length+1][2];
        for(int i=prices.length-1;i>=0;i--){
            for(int j=0;j<2;j++){
                if(j==1){
                    dp[i][j] = Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
                }else{
                    dp[i][j] = Math.max(+prices[i]+dp[i+1][1], dp[i+1][0]);
                }
            }
        }
        int ans = dp[0][1];
        return ans;
    }
}