class Solution {
    public int reverse(int x) {
        int num = 0;

        while (x != 0) {
            int digit = x % 10;

            // Check for overflow before updating num
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0; // Overflow for positive numbers
            }
            if (num < Integer.MIN_VALUE / 10 || (num == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0; // Overflow for negative numbers
            }

            num = num * 10 + digit;
            x /= 10;
        }

        return num;
    }
}
