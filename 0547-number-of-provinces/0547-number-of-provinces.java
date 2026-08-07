class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i!=j && isConnected[i][j] == 1){
                    graph.get(i).add(j);

                }
            }
        }
        int province = 0;
        boolean visited[] = new boolean[n];
        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                province++;
                dfs(graph, visited, i);
            }
        }
        return province;

    }
    private void dfs(List<List<Integer>> graph, boolean visited[], int node){
        visited[node] = true;
        for(int curr : graph.get(node)){
            if(visited[curr] == false){
                dfs(graph, visited, curr);
            }
        }
    }
}