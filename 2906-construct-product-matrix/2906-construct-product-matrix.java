class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int mod = 12345;
        int size = m*n;
        long[] pref = new long[size];
        long[] suf = new long[size];
        long[] arr = new long[size];
        int idx=0;
        for(int[] a : grid){
            for(long x: a){
                arr[idx++] = x;
            }
        }
        pref[0]=1;
        suf[suf.length-1] =1;
        for(int i=1;i<size;i++){
            pref[i] = (pref[i-1]*arr[i-1])%mod;
        }
        for(int i = size-2;i>=0;i--){
            suf[i] = (suf[i+1]*arr[i+1])%mod;
        }
        for(int i=0;i<size;i++){
            long val = (pref[i]*suf[i])%mod;
            grid[i/n][i%n] = (int)val;
        }
        return grid;
    }
}