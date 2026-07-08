class Solution {

    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        // Prefix sum of digits
        long[] digitPrefix = new long[n];
        digitPrefix[0] = s.charAt(0) - '0';

        for (int i = 1; i < n; i++) {
            digitPrefix[i] = digitPrefix[i - 1] + (s.charAt(i) - '0');
        }

        // Store non-zero digits and their positions
        ArrayList<Integer> digits = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                digits.add(d);
                pos.add(i);
            }
        }

        int m = digits.size();

        long[] pref = new long[m + 1];
        long[] pow10 = new long[m + 1];

        pow10[0] = 1;

        for (int i = 0; i < m; i++) {
            pref[i + 1] = (pref[i] * 10 + digits.get(i)) % MOD;
            pow10[i + 1] = (pow10[i] * 10) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            long sum = digitPrefix[r];
            if (l > 0)
                sum -= digitPrefix[l - 1];

            int left = lowerBound(pos, l);
            int right = upperBound(pos, r) - 1;

            long num = 0;

            if (left <= right) {

                int len = right - left + 1;

                num = pref[right + 1]
                        - pref[left] * pow10[len] % MOD;

                num = (num + MOD) % MOD;
            }

            ans[i] = (int) (sum * num % MOD);
        }

        return ans;
    }

    private int lowerBound(ArrayList<Integer> arr, int target) {

        int l = 0, r = arr.size();

        while (l < r) {

            int mid = (l + r) / 2;

            if (arr.get(mid) >= target)
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }

    private int upperBound(ArrayList<Integer> arr, int target) {

        int l = 0, r = arr.size();

        while (l < r) {

            int mid = (l + r) / 2;

            if (arr.get(mid) > target)
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }
}