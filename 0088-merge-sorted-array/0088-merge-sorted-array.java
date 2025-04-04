class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i =0; i<n;i++){
            nums1[m+n-i-1] = nums2[n-i-1];
        }
        Arrays.sort(nums1);
    }
}