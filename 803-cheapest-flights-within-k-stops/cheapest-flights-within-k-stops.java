class Solution {
    class Pair{
        int stop;
        int price;

        Pair(int stop , int price){
            this.stop = stop ;
            this.price = price;
        }
    }

    class Tuple{
        int stop;
        int node;
        int price;

        Tuple(int stop, int node, int price){
            this.stop = stop;
            this.node = node;
            this.price = price;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] flight : flights){
            int u = flight[0];
            int v = flight[1];
            int price = flight[2];
            adj.get(u).add(new Pair(v,price));
            // adj.get(v).add(new Pair(u,price));
        }

        int[] dist = new int[n];

        for(int i = 0; i < n; i++) dist[i] = (int) 1e9;

        dist[src] = 0;

        Queue<Tuple> pq = new LinkedList<>();
        pq.offer(new Tuple(0,src,0));

        while(!pq.isEmpty()){
            Tuple t = pq.poll();
            int stops = t.stop;
            int node = t.node;
            int weight = t.price;

            if(stops > k) continue;

            for(Pair neighbor : adj.get(node)){
                if(weight + neighbor.price < dist[neighbor.stop]){
                    dist[neighbor.stop] = weight + neighbor.price;
                    pq.offer(new Tuple(stops+1, neighbor.stop,dist[neighbor.stop]));
                }
            }
        }
        if(dist[dst] == (int)1e9) return -1;
        return dist[dst];
    }
}