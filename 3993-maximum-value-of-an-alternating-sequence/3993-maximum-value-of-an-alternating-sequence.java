class Solution {
    public long maximumValue(int n, int s, int m) {
        if(n==1) return s;
        long inc = (int) n/2;
        long dec = inc-1;
        return s+inc*m-dec;
    }
}