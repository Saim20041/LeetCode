class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int left = 0;
        int right = tokens.length-1;
        int score = 0;
        int maxScore = 0;
        boolean bool = true;
        Arrays.sort(tokens);
        while(bool && left <= right ){
            if(tokens[left] <= power){
                score++;
                power -= tokens[left];
                left++;
                maxScore = Math.max(maxScore, score);
            }
            else if(score > 0){
                power+=tokens[right];
                score--;
                right--;
            }
            else{
                bool = false;
            }
        }
        return maxScore;
    }
}