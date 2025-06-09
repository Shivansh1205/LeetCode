class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1;  // Start with the smallest lexicographical number (1)
        k--;  // Adjust k to be 0-based index
        
        while (k > 0) {
            int steps = countSteps(current, n);
            if (steps <= k) {
                // If the number of steps with the current prefix is less than k, skip these many numbers
                current++;
                k -= steps;
            } else {
                // Otherwise, go deeper in the tree (move to the next prefix)
                current *= 10;
                k--;  // We're counting this number itself
            }
        }
        
        return current;
    }

    // This function calculates how many numbers are in the range [prefix, n] in lexicographical order
    private int countSteps(int prefix, int n) {
        long count = 0;
        long current = prefix;
        long next = current + 1;
        
        while (current <= n) {
            count += Math.min(n + 1, next) - current;
            current *= 10;
            next *= 10;
        }
        
        return (int) count;
    }
}
