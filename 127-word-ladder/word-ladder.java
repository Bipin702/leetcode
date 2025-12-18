class Solution {
    class Pair{
        String word;
        int length;

        Pair(String word, int length){
            this.word = word;
            this.length = length;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();

        for(String string : wordList){
            set.add(string);
        }

        set.remove(beginWord);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));

        while(!q.isEmpty()){
            Pair p = q.poll();
            String Word = p.word;
            int dist = p.length;

            if(Word.equals(endWord)) return dist;

            for(int i = 0; i < Word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replacedWord = Word.toCharArray();
                    replacedWord[i] = ch;
                    String newWord = new String(replacedWord);
                    if(set.contains(newWord)){
                        set.remove(newWord);
                        q.add(new Pair(newWord,dist+1));
                    }
                }
            } 
        }
        return 0;
    }
}