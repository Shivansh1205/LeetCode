class Solution {
    public List<String> ambiguousCoordinates(String s) {
        List<String> ans = new ArrayList<>();
        s = s.substring(1, s.length() - 1);

        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);

            List<String> leftParts = generate(left);
            List<String> rightParts = generate(right);

            for (String l : leftParts) {
                for (String r : rightParts) {
                    ans.add("(" + l + ", " + r + ")");
                }
            }
        }

        return ans;
    }

    private List<String> generate(String s) {
        List<String> res = new ArrayList<>();

        // no decimal
        if (isValid(s)) res.add(s);

        // with decimal
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);

            if (isValid(left) && isValidDecimal(right)) {
                res.add(left + "." + right);
            }
        }

        return res;
    }

    private boolean isValid(String s) {
        if (s.length() > 1 && s.startsWith("0")) return false;
        return true;
    }

    private boolean isValidDecimal(String s) {
        return !s.endsWith("0");
    }
}