class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char mini = '{';
        for(char ch : letters){
            if(ch>target){
                if (ch<mini){
                    mini = ch;
                }
            }
        }
        if(mini == '{') return letters[0];
        return mini;
    }
}