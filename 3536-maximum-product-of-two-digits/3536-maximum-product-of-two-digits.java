class Solution {
    public int maxProduct(int n) {
        int []a = intToArray(n);
        Arrays.sort(a);
        return (a[a.length-1]*a[a.length-2]);
    }
    public static int[] intToArray(int num) {
    int temp = num;
    int count = 0;

    while (temp > 0) {
        count++;
        temp /= 10;
    }

    int[] arr = new int[count];

    for (int i = count - 1; i >= 0; i--) {
        arr[i] = num % 10;
        num /= 10;
    }

    return arr;
}
}