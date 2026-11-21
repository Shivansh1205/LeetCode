class Solution {
    public int countSuffix(int[] nums, int[] target) {
        int n = nums.length;

        int count = 0;

        Map<Integer, Integer> freq1 = new HashMap<>();
        Map<Integer, Integer> freq2 = new HashMap<>();

        for(int i = 0; i < n; i++){
            freq1.put(nums[i], freq1.getOrDefault(nums[i], 0) + 1);
            freq2.put(target[i], freq2.getOrDefault(target[i], 0) + 1);
        }

        if(!freq1.equals(freq2)){
            return 0;
        }

        int maxI = n - 1;

        for(int i = 0; i < n; i++){
            if(nums[i] != target[i]){
                maxI = i;
                break;
            }
        }

        int minI = 0;

        for(int i = n - 1; i > 0; i--){
            if(target[i] > target[i - 1]){
                minI = i;
                break;
            }
        }
        count = Math.max(0, maxI - minI + 1);

        return count;
    }
}