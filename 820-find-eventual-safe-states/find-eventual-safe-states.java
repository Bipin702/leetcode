class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
       List<List<Integer>> adj = new ArrayList<>();

       for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

       for(int i = 0; i < n; i++){
            for(int neighbor : graph[i]){
                adj.get(i).add(neighbor);
            }
        }


       int[] visited = new int[n];
       int[] pathVisited = new int[n];
       int[] check = new int[n];
       List<Integer> ans = new ArrayList<>();

       for(int i = 0; i < n; i++){
        if(visited[i] == 0){
            dfs(i,visited,pathVisited,check,adj);
        }
       }
       
       for(int i = 0; i < n; i++){
        if(check[i] == 1) ans.add(i);
       }

       return ans;
    }

    public boolean dfs(int node, int[] visited, int[] pathVisited, int[] check, List<List<Integer>> adj){
        visited[node] = 1;
        check[node] = 0;
        pathVisited[node] = 1;

        for(int neighbor : adj.get(node)){
            if(visited[neighbor] == 0){
                if(dfs(neighbor,visited,pathVisited,check,adj)) return true;
            }else if(pathVisited[neighbor] == 1) return true;
        }
        pathVisited[node] = 0;
        check[node] = 1;
        return false;
    }
}