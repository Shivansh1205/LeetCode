class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[nums.length-k+1];
        int j =0;
        for(int i=0;i<nums.length;i++){
            if(!dq.isEmpty() && dq.peek()==i-k) dq.poll();
            while(!dq.isEmpty() && nums[i]>nums[dq.peekLast()]) dq.pollLast();
            dq.offer(i);
            if(i>=k-1){
                ans[j++] = nums[dq.peek()];
            }
        } 
        return ans;
        

    }
}