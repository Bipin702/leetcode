class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
       List<List<Integer>> adj = new ArrayList<>();
       int n = graph.length;

       for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

       for(int i = 0; i < n; i++){
        for(int v : graph[i]){
            adj.get(i).add(v);
        }
    }


       int[] visited = new int[n];
       int[] Check = new int[n];
       int[] pathVisited = new int[n];

       for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                dfs(i,visited,Check,pathVisited,adj);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(Check[i] == 1) safeNodes.add(i);
        }
        return safeNodes;
    }

    public boolean dfs(int node, int[] visited, int[] check, int[] pathVisited, List<List<Integer>> adj){
        visited[node] = 1;
        check[node] = 0;
        pathVisited[node] = 1;

        for(int neighbor : adj.get(node)){
            if(visited[neighbor] == 0){
                if(dfs(neighbor,visited,check,pathVisited,adj)) return true;
            }else if(pathVisited[neighbor] == 1) return true;
        }

        pathVisited[node] = 0;
        check[node] = 1;
        return false;
    }
}