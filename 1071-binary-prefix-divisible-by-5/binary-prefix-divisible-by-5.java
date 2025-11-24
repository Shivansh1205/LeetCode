class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>();
        int cur=0;
        for(int x: nums){
            cur = (cur*2 + x)%5;
            res.add(cur==0);
        }
        return res;
    }
}