class Solution {
    public boolean wordPattern(String pattern, String s) {
        int n = pattern.length();
        String[] arr = s.split(" ");

        if (pattern.length() != arr.length) return false;

        HashMap<Character,String> map1 = new HashMap<>();
        HashMap<String,Character> map2 = new HashMap<>();

        for(int i = 0; i < n; i++){
            char ch = pattern.charAt(i);
            String word = arr[i];

            if(map1.containsKey(ch)){
                if(!map1.get(ch).equals(word)) return false;
            }else{
                map1.put(ch,word);
            }

            if(map2.containsKey(word)){
                if(map2.get(word) != ch) return false;
            }else{
                map2.put(word,ch);
            }
        }
        return true;
    }
}