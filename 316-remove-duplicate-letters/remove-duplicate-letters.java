class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();

        boolean[] taken = new boolean[26];
        int[] lastIndex = new int[26];

        for(int i = 0; i < taken.length; i++){
            taken[i] = false;
        }

        for(int i =  0; i < n; i++){
            char ch = s.charAt(i);
            lastIndex[ch-'a'] = i;
        }

        StringBuilder str = new StringBuilder();

        for(int i = 0; i < n ; i++){
            char ch = s.charAt(i);
            int  index = ch - 'a';
            if(taken[index] == true) continue;

            while(str.length() > 0 && str.charAt(str.length()-1) > ch 
                && lastIndex[str.charAt(str.length()-1) - 'a'] > i){
                    char removed = str.charAt(str.length()-1);
                    str.deleteCharAt(str.length()-1);
                    taken[removed - 'a'] = false;
                }
            str.append(ch);
            taken[ch - 'a'] = true;
        }

        return str.toString();
    }
}