class Solution {
    public boolean divideArray(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> arr = new HashMap<>();
        for(int i =0;i<n;i++){
            arr.put(nums[i], arr.getOrDefault(nums[i], 0) + 1);
        }
        for(int a : arr.keySet()){
            if(arr.get(a)%2!=0){
                return false;
            }
        }
        return true;
        
    }
}