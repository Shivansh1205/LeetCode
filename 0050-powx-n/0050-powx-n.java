class Solution {
    public double myPow(double x, int n) {
    int N = n; 
    if(N<0){
        x = 1/x;
        N=-N;
    }
    return fastpow(x,N);
    
    }

    public double fastpow(double c, int N){
        if (N==0) return 1;
        double half = fastpow(c,N/2);
        if(N%2 == 0) return half*half;
        else return half*half*c;
    }
}
