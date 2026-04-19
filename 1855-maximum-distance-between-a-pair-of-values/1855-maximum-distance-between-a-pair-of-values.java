class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = 0;
        for(int i=0;i<nums1.length;i++){
            int high = nums2.length-1;
            int low = i;
            while(low<=high){
                int mid = low+(high-low)/2;
                if(nums2[mid]<nums1[i]){
                    high = mid-1;
                }else if(nums2[mid]>=nums1[i]){
                    low = mid+1;
                    ans = Math.max(ans,mid-i);
                }
            }
        }
        return ans;
    }
}