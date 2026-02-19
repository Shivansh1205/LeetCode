// class Solution {
//     public int maxProfit(int[] prices) {
//         int [][][]dp = new int[prices.length+1][2][3];
//         for(int i=prices.length-1;i>=0;i--){
//             for(int j=0;j<2;j++){
//                 for(int k=1;k<3;k++){
//                     if(j==1){
//                     dp[i][j][k] = Math.max(-prices[i]+dp[i+1][0][k],dp[i+1][1][k]);
//                     }else{
//                     dp[i][j][k] = Math.max(+prices[i]+dp[i+1][1][k-1], dp[i+1][0][k]);
//                     }
//                 }
//             }
//         }
//         int ans = dp[0][1][2];
//         return ans;
//     }
// }

class Solution {
    public int maxProfit(int[] prices) {
        int [][][]dp = new int[prices.length+1][2][3];
        int[][] cur = new int[2][3];
        int[][] prev = new int[2][3];
        for(int i=prices.length-1;i>=0;i--){
            for(int j=0;j<2;j++){
                for(int k=1;k<3;k++){
                    if(j==1){
                    cur[j][k] = Math.max(-prices[i]+prev[0][k],prev[1][k]);
                    }else{
                    cur[j][k] = Math.max(+prices[i]+prev[1][k-1], prev[0][k]);
                    }
                }
                
            }
            int[][] temp = cur;
            cur= prev;
            prev = temp;
        }
        int ans = prev[1][2];
        return ans;
    }
}