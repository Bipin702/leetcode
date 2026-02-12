class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLength = 0;

        for(int i = 0; i < n; i++){
            int[] freq = new int[26];
            for(int j = i; j < n; j++){
                freq[s.charAt(j)-'a']++;

                if(checkBalance(freq)){
                    maxLength = Math.max(maxLength,j-i+1);
                }
            }
        }
        return maxLength;
    }

    public boolean checkBalance(int[] freq){
        int reference = 0;

        for(int count : freq){
            if(count > 0){
                if(reference == 0){
                    reference = count;
                }else if(reference != count){
                    return false;
                }
            }
        }
        return true;
    }
}