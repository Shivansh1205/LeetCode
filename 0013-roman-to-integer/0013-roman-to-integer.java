class Solution {
    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length()-1; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            if (check(a) < check(b)) {
                res = res - check(a);
            } else{
                res = res + check(a);
            }
        }
        res+=check(s.charAt(s.length()-1));
        return res;
    }

    public int check(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default : throw new IllegalArgumentException("roman numeral invalid");
        }
    }
}
