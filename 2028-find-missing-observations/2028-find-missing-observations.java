class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for(int num : rolls){
            sum+=num;
        }
        int arr[] = new int[n];
        int length = rolls.length + n;
        int req = (length*mean) - sum;
        if(req < n || req > n*6){
            return new int[0];
        } 
        int base = req/n;
        int remain = req%n;
        for(int i = 0; i < n; i++){
            
            arr[i] = base + (i < remain? 1:0);
            
        }
        return arr;

    }
}
   

