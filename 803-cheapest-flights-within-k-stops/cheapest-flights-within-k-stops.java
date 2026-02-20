class Solution {
    class Pair{
        int node;
        int price;

        Pair(int node, int price){
            this.node = node;
            this.price = price;
        }
    }

    class Tuple{
        int stops;
        int node;
        int price;

        Tuple(int stops, int node, int price){
            this.stops = stops;
            this.node = node;
            this.price = price;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] edge : flights){
            int u = edge[0];
            int v = edge[1];
            int price = edge[2];

            adj.get(u).add(new Pair(v,price));
        }

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,src,0));
        int[] dist = new int[n];
        Arrays.fill(dist,(int)1e9);
        dist[src] = 0;
        while(!q.isEmpty()){
            Tuple t = q.poll();
            int nodes = t.node;
            int stop = t.stops;
            int fare = t.price;

            if(stop > k) continue;

            for(Pair neighbor : adj.get(nodes)){
                if(fare + neighbor.price < dist[neighbor.node]){
                    dist[neighbor.node] = fare + neighbor.price;
                    q.add(new Tuple(stop+1,neighbor.node,dist[neighbor.node]));
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(dist[i] == (int)1e9) dist[i] = -1;
        }
        return dist[dst];
    }
}