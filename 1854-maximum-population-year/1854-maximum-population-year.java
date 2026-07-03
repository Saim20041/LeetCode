class Solution {
    public int maximumPopulation(int[][] logs) {
        int arr[] = new int[100];
        for(int i = 0; i < logs.length;i++){
            for(int j = logs[i][0]; j < logs[i][1]; j++){
                arr[j-1950]++;
            }
        }   
        int year = 0;
        int count = 0; 
        for(int i = 0; i < arr.length;i++){
            if(arr[i] > count){
                count = arr[i];
                year = i;
            }
        }
        return year + 1950;
    }
}