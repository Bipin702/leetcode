class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int components = 0;
        boolean[]visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i,visited,stones);
                components++;
            }
        }
        return n - components;
    }
    
    public void dfs(int node, boolean[] visited, int[][] stones){
        visited[node] = true;
        int n = stones.length;
        for(int i = 0; i < n; i++){
            if(!visited[i] && (stones[node][0] == stones[i][0] || stones[node][1] == stones[i][1])){
                dfs(i,visited,stones);
            }
        }
    }
}