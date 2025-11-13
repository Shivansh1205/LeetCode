class Solution {
    public int maxOperations(String s) {
        int ans=0,zer=0;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i) =='1') zer++;
            else if(i == s.length()-1 || s.charAt(i+1) == '1') ans += zer;
        }
        return ans;
    }
}