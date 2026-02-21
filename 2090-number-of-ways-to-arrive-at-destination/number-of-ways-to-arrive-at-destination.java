class Solution {
    class Pair{
        int vertex;
        long weight;

        Pair(int vertex, long weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    public int countPaths(int n, int[][] roads) {
        int mod = (int)1e9+7;
        List<List<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            int wt = road[2];

            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }

        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        Queue<Pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.weight,b.weight));
        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.vertex;
            long distance = p.weight;

            if(distance > dist[node]) continue;

            for(Pair neighbor : adj.get(node)){
                if(dist[node] + neighbor.weight < dist[neighbor.vertex]){
                    dist[neighbor.vertex] = dist[node] + neighbor.weight;
                    pq.add(new Pair(neighbor.vertex,dist[neighbor.vertex]));
                    ways[neighbor.vertex] = ways[node];
                }else if(dist[node] + neighbor.weight == dist[neighbor.vertex]){
                    ways[neighbor.vertex] = (ways[node] + ways[neighbor.vertex]) % mod;
                }
            }
        }
        return ways[n-1];
    }
}