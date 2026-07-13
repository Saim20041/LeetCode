class Solution {
    public int minimumCost(int[] nums, int k) {
        long MOD = 1_000_000_007L;
        long INV2 = 500000004L;

        long curr = k;
        long cost = 0;

        for (int num : nums) {
            if (curr < num) {
                long diff = num - curr;
                long add = (diff + k - 1L) / k; // ceil(diff / k)
                curr += add * k;
                cost += add;
            }
            curr -= num;
        }

        long ans = (cost % MOD) * ((cost + 1) % MOD) % MOD;
        ans = (ans * INV2) % MOD;

        return (int) ans;
    }
}