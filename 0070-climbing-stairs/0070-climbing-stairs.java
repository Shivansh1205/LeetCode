class Solution {
    public int climbStairs(int n) {
        int pre = 1;
        int pre2=1;
        for(int i =2;i<=n;i++){
            int cur = pre +pre2;
            pre2 = pre;
            pre = cur;
        }
        return pre;

    }
}