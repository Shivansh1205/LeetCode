class Solution {
    public boolean uniformArray(int[] nums1) {
        long mini = Long.MAX_VALUE;
        boolean isok = true;
        for(int i=0;i<nums1.length;i++){
            mini = Math.min(mini,nums1[i]);
        }
        if(mini%2==1) return true;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]%2 == 1) {
                isok = false;
                break;
            } 
        }
        return isok;

    }
}