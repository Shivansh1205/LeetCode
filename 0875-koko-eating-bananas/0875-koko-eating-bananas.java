class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = -1;
        for(int i=0;i<piles.length;i++){
            high = Math.max(high,piles[i]);
        }
        while(low<high){
            int mid = (low+high)/2;
            if(possible(piles,h,mid)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    private boolean possible(int[] piles, int h, int k){
        int total =0;
        for(int x : piles){
            total += (x+k-1)/(k);
        }
        return total<=h;
    }
}