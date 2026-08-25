class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> st = new HashSet<>();
        for(int num : nums){
            st.add(num);
        }
        int cur = k;
        while(st.contains(cur)) cur += k;
        return cur;
    }
}