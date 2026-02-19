class Solution {
    class Pair{
        String word;
        int time;

        Pair(String word, int time){
            this.word = word;
            this.time = time;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();

        for(String list : wordList) set.add(list);
        set.remove(beginWord);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));

        while(!q.isEmpty()){
            Pair p = q.poll();
            String begin = p.word;
            int tm = p.time;
            if(begin.equals(endWord)) return tm;

            for(int i = 0; i < begin.length();i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replaced = begin.toCharArray();
                    replaced[i] = ch;
                    String newWord = new String(replaced);

                    if(set.contains(newWord)){
                        set.remove(newWord);
                        q.add(new Pair(newWord,tm+1));
                    }
                }
            }
        }
        return 0;
    }
}