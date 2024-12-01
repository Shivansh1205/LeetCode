int* frequencySort(int* nums, int n, int* returnSize) {
    *returnSize = n;

    // Dynamically allocate memory
    int* count = (int*)malloc(n * sizeof(int));
    for (int i = 0; i<n; i++) {
        count[i] = 0;
    }

    // create a frequency array
    for (int i = 0; i <n; i++) {
        for (int j = 0; j< n; j++) {
            if (nums[i] == nums[j]) {
                count[i]++;
            }
        }
    }

    // Sort the result array based on frequency and value
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (count[i] > count[j]) {
                // Swap frequencies
                int temp = count[i];
                count[i] = count[j];
                count[j] = temp;

                // Swap elements based on frequency
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            } 
            else if (count[i] == count[j]) {
                if (nums[i] < nums[j]) {
                    //edge case descending order arrangement
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
        }
    }
    return nums;
}
