class Solution {
    public int maxProduct(int n) {
        int arr[] = new int[10];
        
        while(n != 0){
            int num = n%10;
            n/=10;
            arr[num]++;
        }
        int num1 = 0;
        int num2 = 0;
        for(int i = arr.length-1; i>=0; i--){
            if(arr[i] > 0){
                num1 = i;
                arr[i]--;
                break;
            }
        }
        for(int i = arr.length-1; i>=0; i--){
            if(arr[i] > 0){
                num2 = i;
                break;
            }
        }
        return num1*num2;
    }
}