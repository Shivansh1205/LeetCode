class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i =0; i<n; i++){
            high +=weights[i];
            low = Math.max(weights[i],low);
        }
        while(low<=high){
            int mid = (low+high)/2;
            if(possible(weights,mid)<days) high = mid-1;
            else low = mid+1;
            
        }
        return low;
    }
    public int possible(int[] weights, int d){
        int load  = 0,days=0;
        int n = weights.length;
        for(int i = 0 ; i<n ; i++){
            if(load+weights[i]>d){
                days++;
                load = weights[i];
            }else{
                load+=weights[i];
            }
        }
        return days;
    }
}