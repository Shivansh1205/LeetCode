class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0){
            return res;
        }
        String[] map ={
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        backtrack(res,digits,map,0, new StringBuilder());
        return res;
    }
    public void backtrack(List<String> res, String digits,String[] map, int ind, StringBuilder sb){
        if(ind == digits.length()){
            res.add(sb.toString());
            return;
        }
        String letters = map[digits.charAt(ind)-'0'];
        for(char ch : letters.toCharArray()){
            sb.append(ch);
            backtrack(res,digits,map,ind+1,sb);
            sb.deleteCharAt(sb.length()-1);

        }
    }
}