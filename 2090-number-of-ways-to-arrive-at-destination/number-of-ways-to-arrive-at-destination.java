class Solution {
    class Pair{
        int node;
        long weight;

        Pair(int node, long weight){
            this.node = node;
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
        for(int i = 0; i < n; i++){
            dist[i] = Long.MAX_VALUE;
        }
        dist[0] = 0;
        int[] ways = new int[n];
        Arrays.fill(ways,0);
        ways[0] = 1;
        Queue<Pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.weight,b.weight));
        pq.offer(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int nodes = p.node;
            long distance = p.weight;
            if (distance > dist[nodes]) continue;

            for(Pair neighbor : adj.get(nodes)){
                if(distance + neighbor.weight < dist[neighbor.node]){
                    dist[neighbor.node] = distance + neighbor.weight;
                    pq.offer(new Pair(neighbor.node,dist[neighbor.node]));
                    ways[neighbor.node] = ways[nodes];
                }else if(distance + neighbor.weight == dist[neighbor.node]){
                    ways[neighbor.node] = (ways[nodes] + ways[neighbor.node])%mod;
                }
            }
        }
        return ways[n-1]%mod;
    }
}