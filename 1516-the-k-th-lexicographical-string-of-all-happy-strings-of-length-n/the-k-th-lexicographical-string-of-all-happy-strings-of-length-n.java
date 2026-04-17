class Solution {
    public String getHappyString(int n, int k) {
        HashSet<String> set = new HashSet<>();
        StringBuilder temp = new StringBuilder();
        char[] arr = {'a','b','c'};
        f(arr,n,k,set,temp,0);
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        if(list.size()<k) return "";
        return list.get(k-1);

    }
    private void f(char[] arr, int n, int k, Set<String> set, StringBuilder temp, int idx){
        if(idx>=arr.length) return;
        if(n==0) {
            set.add(temp.toString());
            return ;
        }
        if (temp.length() > 0 && temp.charAt(temp.length() - 1) == arr[idx]) {
            f(arr, n, k, set, temp, idx + 1);
            return;
        }

        // ✅ take current
        temp.append(arr[idx]);
        f(arr, n - 1, k, set, temp, 0); // restart choices
        temp.deleteCharAt(temp.length() - 1);

        // ✅ skip current
        f(arr, n, k, set, temp, idx + 1);
    }
}