// class Solution {
//     public int change(int amount, int[] coins) {
//         int[][] dp = new int[coins.length][amount+1];
//         for(int[] a :dp){
//             Arrays.fill(a,-1);
//         }
//         int ans = f(amount, coins, coins.length-1,dp);
//         return ans;
//     }
//     private int f(int amount, int[] coins, int idx,int[][] dp){
//         if(idx<=0) return (amount%coins[0] ==0)?1:0;
//         if(dp[idx][amount]!=-1) return dp[idx][amount];
//         int np = f(amount, coins,idx-1,dp);
//         int p = 0;
//         if(coins[idx] <= amount){
//             p = f(amount-coins[idx],coins, idx,dp);
//         }
//         return dp[idx][amount]=p+np;

//     }
// }
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int t=0;t<=amount;t++){
            if(t%coins[0]==0) dp[0][t]=1;
        }
        for(int i=1;i<coins.length;i++){
            for(int t=0;t<=amount;t++){
                int np = dp[i-1][t];
                int p = 0;
                if(coins[i] <= t){
                    p = dp[i][t-coins[i]];
                }
                dp[i][t] = p+np;
            }
        }
        int ans = dp[coins.length-1][amount];
        return ans;
    }
}