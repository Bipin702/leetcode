class Solution {
    class Pair implements Comparable<Pair>{
        int num;
        int frequency;

        Pair(int num, int frequency){
            this.num = num;
            this.frequency = frequency;
        }

        public int compareTo(Pair p2){
            return (p2.frequency-this.frequency);
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            Pair p = new Pair(entry.getKey(),entry.getValue());
            pq.offer(p);
        }
        int[] res = new int[k];
        int index = 0;

        while(index < k){
            Pair p = pq.poll();
            res[index] = p.num;
            index++;
        }
        return res;
    }
}