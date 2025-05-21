
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr); 
        backtrack(0, arr, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int[] arr, List<Integer> current, List<List<Integer>> res) {
        res.add(new ArrayList<>(current)); 

        for (int i = start; i < arr.length; i++) {
            
            if (i > start && arr[i] == arr[i - 1]) continue;

            current.add(arr[i]);
            backtrack(i + 1, arr, current, res);
            current.remove(current.size() - 1); 
        }
    }
}
