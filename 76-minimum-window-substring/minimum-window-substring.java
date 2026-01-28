class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(m > n) return "";

        int minLength = Integer.MAX_VALUE;
        int start_i = 0;

        int countReq = t.length();
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < m; i++){
            char ch = t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int i = 0;
        int j = 0;

        while(j < n){
            char ch = s.charAt(j);

            if(map.containsKey(ch) && map.get(ch) > 0){
                countReq--;
            }

            map.put(ch,map.getOrDefault(ch,0)-1);

            while(countReq == 0){
                int windowSize = j - i + 1;

                if(windowSize < minLength){
                    minLength = windowSize;
                    start_i = i;
                }

                map.put(s.charAt(i),map.get(s.charAt(i))+1);

                if(map.get(s.charAt(i)) > 0){
                    countReq++;
                }
                i++;
            }
            j++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start_i,start_i+minLength);
    }
}