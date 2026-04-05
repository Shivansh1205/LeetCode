class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        
        int i = 0, j = 0, k = 0;
        
        // merge
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                arr[k++] = nums1[i++];
            } else {
                arr[k++] = nums2[j++];
            }
        }
        
        while (i < nums1.length) {
            arr[k++] = nums1[i++];
        }
        
        while (j < nums2.length) {
            arr[k++] = nums2[j++];
        }
        
        int total = arr.length;
        
        // median
        if (total % 2 == 0) {
            return (arr[total/2 - 1] + arr[total/2]) / 2.0;
        } else {
            return arr[total/2];
        }
    }
}
