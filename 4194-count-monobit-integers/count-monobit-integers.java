class Solution {
    public int countMonobit(int n) {
        int ans=1;
        int x=1;
        while(x<=n){
            ans++;
            x= (x<<1)|1;
        }
        return ans;
    }
}