class Solution {
    public int minRange(int a, int b, int c) {
        int arr[] = new int[]{a,b,c};
        Arrays.sort(arr);
        int min = arr[2] - arr[0];
        if(arr[0]+arr[1] < arr[2]){
            min = Math.min(min, arr[1]);
        }
        min=Math.min(min, arr[2]);
        
        return min;
    }
}