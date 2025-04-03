class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }   
        List<Integer> val =new ArrayList<>(); 
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()>(n/3)){
                val.add(entry.getKey());
            }
        }
        return val;
    }
}