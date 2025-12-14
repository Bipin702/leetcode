class Solution {
    public int characterReplacement(String s, int k) {
       int n = s.length();
       int[] count = new int[26];
       int left = 0;
       int maxFreq = 0;
       int maxLen = 0;
       for(int right = 0; right < n; right++){
         char ch = s.charAt(right);
         count[ch-'A']++;
         maxFreq = Math.max(maxFreq,count[ch-'A']);

         while((right-left+1) - maxFreq > k){
            count[s.charAt(left)-'A']--;
            left++;
         }
         maxLen = Math.max(maxLen,(right-left+1));
       }
       return maxLen;
    }
}