class Solution {
    public boolean checkDivisibility(int n) {
        int sum =0;
        int pro = 1;
        int val = n;
        while(n>0){
            int cur = n%10;
            n = n/10;
            sum+= cur;
            pro = pro*cur;
        }
        if(val%(sum+pro) == 0) return true;
        return false;
    }
}