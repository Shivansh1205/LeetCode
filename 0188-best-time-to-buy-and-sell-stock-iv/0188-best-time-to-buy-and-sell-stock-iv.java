class Solution {
    public int maxProfit(int m, int[] prices) {
        int[][] cur = new int[2][m+1];
        int[][] prev = new int[2][m+1];
        for(int i=prices.length-1;i>=0;i--){
            for(int j=0;j<2;j++){
                for(int k=1;k<m+1;k++){
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
        int ans = prev[1][m];
        return ans;
    }        
}