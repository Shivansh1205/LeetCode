//recursion function 
int distinctHelper(int i, int j, char *s, char *t, int m, int n, int **arr) {
    if (j == n) return 1; // size of t = 0
    if (i == m) return 0; // size of s = 0

    if (arr[i][j] != -1) return arr[i][j]; //checks if it is already calculated

    if (s[i] == t[j]) {
        arr[i][j] = distinctHelper(i + 1, j + 1, s, t, m, n, arr) +
                     distinctHelper(i + 1, j, s, t, m, n, arr);
    } else {
        arr[i][j] = distinctHelper(i + 1, j, s, t, m, n, arr);
    }

    return arr[i][j];
}

int numDistinct(char *s, char *t) {
    int m = strlen(s);
    int n = strlen(t);

    // Create a array table
    int **arr = (int **)malloc(m * sizeof(int *));
    for (int i = 0; i < m; i++) {
        arr[i] = (int *)malloc(n * sizeof(int));
        for (int j = 0; j < n; j++) {
            arr[i][j] = -1; // Initialize with -1
        }
    }

    int result = distinctHelper(0, 0, s, t, m, n, arr);

    // Free 
    for (int i = 0; i < m; i++) {
        free(arr[i]);
    }
    free(arr);

    return result;
}
