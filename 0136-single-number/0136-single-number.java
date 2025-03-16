class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int res =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        for(int key: map.keySet()){
            if(map.get(key)==1){
                res = key;
                break;
            }
        }
        return res;
    }
}