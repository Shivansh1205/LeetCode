#include <string.h>
#include <stdlib.h>

// Helper function for memoized recursion
int distinctHelper(int i, int j, char *s, char *t, int m, int n, int **memo) {
    if (j == n) return 1; // If `t` is fully matched
    if (i == m) return 0; // If `s` is exhausted without fully matching `t`

    if (memo[i][j] != -1) return memo[i][j]; // Return cached result if available

    if (s[i] == t[j]) {
        memo[i][j] = distinctHelper(i + 1, j + 1, s, t, m, n, memo) +
                     distinctHelper(i + 1, j, s, t, m, n, memo);
    } else {
        memo[i][j] = distinctHelper(i + 1, j, s, t, m, n, memo);
    }

    return memo[i][j];
}

int numDistinct(char *s, char *t) {
    int m = strlen(s);
    int n = strlen(t);

    // Create a memoization table
    int **memo = (int **)malloc(m * sizeof(int *));
    for (int i = 0; i < m; i++) {
        memo[i] = (int *)malloc(n * sizeof(int));
        for (int j = 0; j < n; j++) {
            memo[i][j] = -1; // Initialize with -1
        }
    }

    int result = distinctHelper(0, 0, s, t, m, n, memo);

    // Free memoization table
    for (int i = 0; i < m; i++) {
        free(memo[i]);
    }
    free(memo);

    return result;
}
