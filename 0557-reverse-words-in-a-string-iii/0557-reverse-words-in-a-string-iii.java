class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        for(String word : words){
            StringBuilder rev = new StringBuilder(word).reverse();
            res.append(rev).append(" ");

        }
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }
}