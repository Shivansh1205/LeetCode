class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long n = bloomDay.length;
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        if(n<(long)m*k){
            return -1;
        }
        for(int i = 0; i<n;i++){
            mini = Math.min(bloomDay[i],mini);
            maxi = Math.max(bloomDay[i],maxi);
        }
        int low = mini;
        int high = maxi;
        while(low<=high){
            int mid= (low+high)/2;
            if(possible(bloomDay,mid,m,k)){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
    public boolean possible(int[] bloomDay, int d, int m, int k){
    int cnt = 0, bouquets = 0;
    for (int i = 0; i < bloomDay.length; i++) {
        if (bloomDay[i] <= d) {
            cnt++;
            if (cnt == k) {
                bouquets++;
                cnt = 0; 
            }
        } else {
            cnt = 0; 
        }
    }
    return bouquets >= m;
}

}