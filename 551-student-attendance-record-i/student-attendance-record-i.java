class Solution {
    public boolean checkRecord(String s) {
        int cnta =0,cntb=0;
        for(char c: s.toCharArray()){
            if(c!='L') cntb=0;
            if(c=='L')cntb++;
            if(c=='A')cnta++;
            if(cnta==2 || cntb==3) return false;
        }
        return true;
    }
}