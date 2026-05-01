class Solution {
    public String sortVowels(String s) {
        int[] freq = new int[5];
        int[] firstIdx = new int[5];
        Arrays.fill(firstIdx, -1);


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = getIndex(c);
            if (idx != -1) {
                freq[idx]++;
                if (firstIdx[idx] == -1) {
                    firstIdx[idx] = i;
                }
            }
        }


        Integer[] indices = {0,1,2,3,4};

        Arrays.sort(indices, (a, b) -> {
            if (freq[b] != freq[a]) {
                return freq[b] - freq[a]; 
            }
            return firstIdx[a] - firstIdx[b]; 
        });

 
        StringBuilder res = new StringBuilder();
        int ptr = 0; 

        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                while (ptr < 5 && freq[indices[ptr]] == 0) {
                    ptr++;
                }

                int v = indices[ptr];
                res.append(getChar(v));
                freq[v]--;
            } else {
                res.append(c);
            }
        }

        return res.toString();
    }

    private int getIndex(char c) {
        if (c == 'a') return 0;
        if (c == 'e') return 1;
        if (c == 'i') return 2;
        if (c == 'o') return 3;
        if (c == 'u') return 4;
        return -1;
    }

    private char getChar(int i) {
        return "aeiou".charAt(i);
    }

    private boolean isVowel(char c) {
        return getIndex(c) != -1;
    }
}