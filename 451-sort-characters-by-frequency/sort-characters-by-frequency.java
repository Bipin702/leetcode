class Solution {
    class Pair implements Comparable<Pair>{
        char ch;
        int frequency;

        Pair(char ch, int frequency){
            this.ch = ch;
            this.frequency = frequency;
        }

        public int compareTo(Pair p2){
            return (p2.frequency - this.frequency);
        }
    }
    public String frequencySort(String s) {
        int n = s.length();

        HashMap<Character,Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            Pair p = new Pair(entry.getKey(),entry.getValue());
            pq.offer(p);
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            Pair p = pq.poll();

            for(int i = 0; i < p.frequency; i++){
                sb.append(p.ch);
            }
        }
        return sb.toString();
    }
}