class Solution {
    public List<Integer> gen(int row){
        int ans = 1;

        List<Integer> list = new ArrayList<>();
        list.add(ans);
        for(int i=1;i<row;i++){
            ans = ans*(row-i);
            ans = ans/(i);
            list.add(ans);
        }
        return list;
    }
    public List<List<Integer>> generate(int n) {
       List<List<Integer>> temp = new ArrayList<>();
       for(int i =1; i<=n; i++){
            temp.add(gen(i));
       } 
       return temp;
    }
}