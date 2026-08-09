class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int left = 0;
        int count = 0;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += (double) arr[i];
        }
        if (sum / k >= (double) threshold) {
            count++;
        }
        for (int right = k; right < n; right++) {
            sum += arr[right];
            sum -= arr[right - k];
            if (sum / k >= (double) threshold) {
                count++;
            }
        }
        return count;
    }
}