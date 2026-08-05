class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        boolean visited[] = new boolean[n];
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        for(int arr[] : invocations){
            list.get(arr[0]).add(arr[1]);
        }
        dfs(k, list, visited);
        List<Integer> check = new ArrayList<>();
        boolean bool = false;
        for(int i = 0; i < invocations.length; i++){
            int first = invocations[i][0];
            int sec = invocations[i][1];
            if(visited[sec] == true && visited[first] == false){
                bool = true;
            }
        }
        if(bool == true){
            List<Integer> all = new ArrayList<>();
            for(int i = 0; i < n; i++){
                all.add(i);
            }
            return all;
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                result.add(i);
            }
        }
        return result;


    }
    private void dfs(int node, List<List<Integer>> list, boolean visited[]){
        visited[node] = true;
        for(int i : list.get(node)){
            if(!visited[i]){
                dfs(i, list, visited);
            }
        }
    }  
}