class Solution {
    public boolean makesquare(int[] nums) {
        int total =0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        if(total%4!=0) return false;
        Arrays.sort(nums);
        return f(nums, total/4, 0,0,0,0,nums.length-1);
    }
    private boolean f(int[] nums, int target, int top, int bottom, int left, int right,int idx){
        if(top == target && right == target && left == target && bottom == target) return true;
        if(top>target || bottom>target || right>target || left>target) return false;
        int val = nums[idx];
        boolean t = f(nums,target,top +val, bottom,left,right,idx-1);
        if(t) return true;
        boolean b = f(nums,target,top,bottom+val,right,left,idx-1);
        if(b) return true;
        boolean r = f(nums,target,top,bottom,right+val, left,idx-1);
        if(r) return true;
        boolean l = f(nums,target,top,bottom,right,left+val,idx-1);
        if(l) return true;
        return false;
    }
}