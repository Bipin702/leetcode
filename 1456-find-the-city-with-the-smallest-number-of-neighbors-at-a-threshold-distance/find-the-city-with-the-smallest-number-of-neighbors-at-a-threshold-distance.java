class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = (i == j) ? 0 : Integer.MAX_VALUE;
            }
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(dist[j][i] != Integer.MAX_VALUE && dist[i][k] != Integer.MAX_VALUE)
                    dist[j][k] = Math.min(dist[j][k],dist[j][i]+dist[i][k]);
                }
            }
        }

        int city = -1;
        int cityMax = n+1;

        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(i != j && dist[i][j] <= distanceThreshold){
                    count++;
                }
            }
            if(count <= cityMax){
                cityMax = count;
                city = i;
            }
        }
        return city;
    }
}