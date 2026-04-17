class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int res = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                res = Math.min(res, i-(map.get(nums[i])));
            }
            int ele = rev(nums[i]);
            map.put(ele,i);
        }
        return res==Integer.MAX_VALUE?-1:res;

    }
    private int rev(int num){
        int rev = 0;
        while(num!=0){
            int dig = num%10;
            rev = rev*10 +dig;
            num = num/10;
        }
        return rev;
    }
}