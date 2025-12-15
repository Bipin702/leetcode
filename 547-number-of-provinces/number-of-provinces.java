class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int result = 0;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int[] visited = new int[n];

        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                result++;
                dfs(i,adj,visited);
            }
        }
        return result;
    }

    public void dfs(int node, List<List<Integer>> adj,int[] visited){
        visited[node] = 1;

        for(int neighbor : adj.get(node)){
            if(visited[neighbor] == 0){
                dfs(neighbor,adj,visited);
            }
        }
    }
}