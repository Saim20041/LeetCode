class Solution {
    public boolean canCross(int[] stones) {
        Boolean dp[][] = new Boolean[stones.length][stones.length];
        return jump(stones[0], 0, 0, stones, dp);
    }

    public boolean jump(int curr, int prevJump, int idx, int[] stones, Boolean dp[][]) {

        if (curr == stones[stones.length - 1]) {
            return true;
        }
        if(dp[idx][prevJump] != null){
            return dp[idx][prevJump];
        }

        for (int i = idx + 1; i < stones.length; i++) {

            int distance = stones[i] - curr;

            if (distance > prevJump + 1) {
                break;
            }

            if (distance == prevJump - 1 ||
                distance == prevJump ||
                distance == prevJump + 1) {

                if (jump(stones[i], distance, i, stones, dp)) {
                    dp[idx][prevJump] = true;
                    return dp[idx][prevJump];
                }
            }
        }
        dp[idx][prevJump] = false;
        return dp[idx][prevJump];
    }
}