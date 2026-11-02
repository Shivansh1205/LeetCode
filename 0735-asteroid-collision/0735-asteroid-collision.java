class Solution {
    public int[] asteroidCollision(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        
        for(int i=0;i<n;i++){
            boolean alive  = true;
            while(alive && nums[i]<0 && !st.isEmpty() && st.peek()>0){
                if(-nums[i] < (st.peek())){
                    alive = false;
                }else if(-nums[i] > (st.peek())){
                    st.pop();
                }else{
                    st.pop();
                    alive = false;
                }
            }
            if(alive){
                st.push(nums[i]);
            }
        }
        int [] ans = new int[st.size()];
        int i=st.size()-1;
        while(!st.isEmpty()){
            ans[i] = st.pop();
            i--;
        }
        return ans;
    }
}