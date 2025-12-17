class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        char[] word = s.toCharArray();
        int l = 0;
        int r = n-1;
        String vowels = "aeiouAEIOU";
        while(l < r){
            while(l < r && vowels.indexOf(word[l]) == -1) l++;

            while(l < r && vowels.indexOf(word[r]) == -1) r--;

            char temp = word[l];
            word[l] = word[r];
            word[r] = temp;

            l++;
            r--;
        }
        String answer = new String(word);
        return answer;
    }
}