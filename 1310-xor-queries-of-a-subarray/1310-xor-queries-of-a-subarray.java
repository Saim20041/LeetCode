class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int prefix[] = new int[arr.length+1];
        int insert = 1;
        for(int i = 0; i < arr.length; i++){
            prefix[insert] = prefix[insert-1] ^ arr[i];
            insert++;
        }
        int result[] = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            result[i] = prefix[end+1] ^ prefix[start];
        }
        return result;
    }
}