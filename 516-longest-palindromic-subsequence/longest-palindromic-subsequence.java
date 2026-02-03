// class Solution {
//     public int longestPalindromeSubseq(String s) {
//         int [][] dp = new int[s.length()][s.length()];
//         for(int[] a : dp){
//             Arrays.fill(a,-1);
//         }
//         String t = new StringBuilder(s).reverse().toString();
//         int ans = f(s,t,s.length()-1,t.length()-1,dp);
//         return ans;
//     }
//     private int f(String s, String t, int ind1, int ind2,int[][] dp){
//         if(ind1<0 || ind2<0) return 0;
//         if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
//         if(s.charAt(ind1) == t.charAt(ind2)) return 1+f(s,t,ind1-1,ind2-1,dp);
//         return dp[ind1][ind2]=Math.max(f(s,t,ind1-1,ind2,dp),f(s,t,ind1,ind2-1,dp));
//     }
// }
class Solution {
    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();
        int [] pre = new int[s.length()+1];
        int[] cur = new int[s.length()+1];
        for(int i=0;i<s.length();i++) {
            pre[i] = 0;
        }
        cur[0]=0;
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=s.length();j++){
                if(s.charAt(i-1) == t.charAt(j-1)) cur[j] = 1+pre[j-1];
                else cur[j] = Math.max(pre[j],cur[j-1]);
            }
            int[] temp = pre;
            pre= cur ;
            cur = temp;
            Arrays.fill(cur,0);
        }
        int ans = pre[s.length()];
        return ans;
    }
}