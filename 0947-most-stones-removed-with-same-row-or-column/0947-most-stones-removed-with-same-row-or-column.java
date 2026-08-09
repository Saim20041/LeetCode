class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (stones[i][0] == stones[j][0] ||
                        stones[i][1] == stones[j][1]) {

                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        int total = 0;
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited);
                total++;
            }
        }
        return n - total;

    }

    private void dfs(int node, List<List<Integer>> graph, boolean visited[]) {
        visited[node] = true;
        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                dfs(neighbour, graph, visited);
            }
        }
    }
}