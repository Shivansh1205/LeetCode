class Solution {
    public int calculateScore(int a, int b) {
        int cnta=0;
        while(a!=0){
            cnta+= a&1;
            a>>=1;
        }
        int cntb =0;
        while(b!=0){
            cntb+=b&1;
            b>>=1;
        }
        if(cnta>=cntb) return cnta*cntb;
        return (int)cntb/cnta;
    }
}