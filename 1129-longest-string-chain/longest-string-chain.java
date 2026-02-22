class Solution {
    public int longestStrChain(String[] words) {
        int[] dp = new int[words.length];
        int maxi=0;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Arrays.fill(dp,1);
        for(int i=0;i<words.length;i++){
            for(int j =0;j<i;j++){
                if(compare(words[i],words[j]) && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
            maxi = Math.max(maxi,dp[i]);
        }
        return maxi;
    }
    private boolean compare(String s1, String s2){
        if(s1.length() != s2.length()+1) return false;
        int p1=0,p2=0;
        while(p1<s1.length() && p2<s2.length()){
            if(s1.charAt(p1) == s2.charAt(p2)){
                p1++;
                p2++;
            }else{
                p1++;
            }
        }
        return p2 == s2.length();
    }
}