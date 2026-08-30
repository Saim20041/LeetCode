class Solution {
    public String[] findRelativeRanks(int[] score) {
        Integer arr[] = new Integer[score.length];
        for(int i = 0; i < score.length; i++){
            arr[i] = i;
        }
        Arrays.sort(arr, (a,b) -> score[b] - score[a]);
        String res[] = new String[score.length];
        for(int i = 0; i < arr.length; i++){
            int index = arr[i];
            if(i == 0){
                res[index] = "Gold Medal";
            }
            else if(i == 1){
                res[index] = "Silver Medal";
            }
            else if(i == 2){
                res[index] = "Bronze Medal";
            }
            else{
                res[index] = String.valueOf(i+1);
            }
        }
        return res;
    }
}