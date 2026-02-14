class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int count = 0;
        int[] visited = new int[n];

        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                count++;
                dfs(i,visited,adj);
            }
        }
        return count;
    }

    public void dfs(int node, int[] visited, List<List<Integer>> adj){
        visited[node] = 1;

        for(int neighbor : adj.get(node)){
            if(visited[neighbor] == 0)
            dfs(neighbor,visited,adj);
        }
    }
}