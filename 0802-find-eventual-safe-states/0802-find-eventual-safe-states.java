class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int visited[] = new int[n];
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            
            if(!dfs(i, visited, graph)){
                res.add(i);
        
            }

        }
        return res;
    }
    public boolean dfs(int i, int visited[], int graph[][]){
        visited[i] = 1;
        for(int neighbour : graph[i]){
            if(visited[neighbour] == 0){
                if(dfs(neighbour, visited, graph)){
                    return true;
                }
            }
            if(visited[neighbour] == 1){
                return true;
            }
        }
        visited[i] = 2;
        return false;
    }
}