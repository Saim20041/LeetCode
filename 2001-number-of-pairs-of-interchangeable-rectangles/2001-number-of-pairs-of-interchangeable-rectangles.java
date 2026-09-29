class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Integer> map = new HashMap<>();
        long total = 0;
        for(int arr[] : rectangles){
            double div = (double) arr[0]/arr[1];
            if(map.containsKey(div)){
                total+=map.get(div);
            }
            map.put(div, map.getOrDefault(div, 0) + 1);
        }
        return total;
    }
}