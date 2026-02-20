class Solution {
    public String makeLargestSpecial(String s) {
        List<String> list = new ArrayList<>();
        int count = 0;
        int start = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
            else count--;
            
            if (count == 0) {
                // recursively solve inside
                String inner = makeLargestSpecial(s.substring(start + 1, i));
                list.add("1" + inner + "0");
                start = i + 1;
            }
        }
        
        // sort descending for lexicographically largest
        Collections.sort(list, Collections.reverseOrder());
        
        return String.join("", list);
    }
}
