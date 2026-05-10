class Solution {

    public int[] countWordOccurrences(String[] chunks, String[] queries) {

        StringBuilder sb = new StringBuilder();

        for(String s : chunks){
            sb.append(s);
        }

        String str = sb.toString();

        Map<String, Integer> map = new HashMap<>();

        int n = str.length();
        int i = 0;

        while(i < n){

            // start of a word
            if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){

                StringBuilder word = new StringBuilder();

                while(i < n){

                    char ch = str.charAt(i);

                    // lowercase letter
                    if(ch >= 'a' && ch <= 'z'){
                        word.append(ch);
                    }

                    // valid hyphen
                    else if(
                        ch == '-' &&
                        i > 0 &&
                        i < n - 1 &&
                        Character.isLowerCase(str.charAt(i - 1)) &&
                        Character.isLowerCase(str.charAt(i + 1))
                    ){
                        word.append(ch);
                    }

                    else{
                        break;
                    }

                    i++;
                }

                String w = word.toString();

                map.put(w, map.getOrDefault(w, 0) + 1);
            }

            else{
                i++;
            }
        }

        int[] ans = new int[queries.length];

        for(i = 0; i < queries.length; i++){
            ans[i] = map.getOrDefault(queries[i], 0);
        }

        return ans;
    }
}