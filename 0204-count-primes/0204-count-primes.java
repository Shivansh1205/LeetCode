class Solution {
    public int countPrimes(int n) {
       if(n<=1) return 0;
       boolean[] isprime = new boolean[n];
       Arrays.fill(isprime,true);
       isprime[0] = false;
       isprime[1] = false;
       for(int i =2 ; i*i<n;i++){
            if(isprime[i]){
                for(int j=i*i;j<n;j+=i){
                    isprime[j] = false;
                }
            }
       }
       int cnt=0;
       for(boolean b: isprime){
            if(b) cnt++; 
       }
       return cnt;
    }
}