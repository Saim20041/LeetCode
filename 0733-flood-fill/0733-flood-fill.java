class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int start = image[sr][sc];
        boolean visited[][] = new boolean[image.length][image[0].length]; 
        helper(sr, sc, start, color, image, visited);
        return image;
    }
    private void helper(int i, int j, int start, int color, int image[][], boolean visited[][]){
        
        if(i < 0 || i >= image.length || j < 0 || j >= image[0].length || start != image[i][j] || visited[i][j]){

            return;
        }
        visited[i][j] = true;
        image[i][j] = color;
        helper(i,j+1,start,color,image,visited);
        helper(i,j-1,start,color,image,visited);
        helper(i+1,j,start,color,image,visited);
        helper(i-1,j,start,color,image,visited);

    }
}