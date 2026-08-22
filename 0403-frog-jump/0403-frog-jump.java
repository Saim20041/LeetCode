class Solution {
    public boolean canCross(int[] stones) {
        Boolean dp[][] = new Boolean[stones.length][stones.length];
        return jump(0, 0, stones, dp);
    }

    public boolean jump(int prevJump, int idx, int[] stones, Boolean dp[][]) {

        if (stones[idx] == stones[stones.length - 1]) {
            return true;
        }
        if(dp[idx][prevJump] != null){
            return dp[idx][prevJump];
        }

        for (int i = idx + 1; i < stones.length; i++) {

            int distance = stones[i] - stones[idx];

            if (distance > prevJump + 1) {
                break;
            }

            if (distance == prevJump - 1 ||
                distance == prevJump ||
                distance == prevJump + 1) {

                if (jump(distance, i, stones, dp)) {
                    dp[idx][prevJump] = true;
                    return dp[idx][prevJump];
                }
            }
        }
        dp[idx][prevJump] = false;
        return dp[idx][prevJump];
    }
}