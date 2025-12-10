class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int n = stones.length;

        for(int num : stones){
            pq.offer(num);
        }

        while(pq.size() > 1){
            int x = pq.poll();
            int y = pq.poll();

            if(x != y) pq.offer(x - y);
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}