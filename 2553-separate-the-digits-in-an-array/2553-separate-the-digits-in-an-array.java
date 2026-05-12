class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int x : nums){
            String s=String.valueOf(x);
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                list.add(c-'0');
            }
        }
        int[] arr = new int[list.size()];
        for(int i=0;i<arr.length;i++){
            arr[i] = list.get(i);
        }
        return arr;

    }
    
}