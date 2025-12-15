class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int left = 0;
        int r = 0;
        int[] hash = new int[256];
        int startIndex = -1;
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        for(char c : t.toCharArray()){
            hash[c]++;
        }

        char[] chS = s.toCharArray();

        while(r < n){
            if(hash[chS[r]] > 0){
                count++;
            }
            hash[chS[r]]--;

            while(count == m){
                if(r-left+1 < minLen){
                    minLen = r-left+1;
                    startIndex = left;
                }
                hash[chS[left]]++;
                if(hash[chS[left]] > 0) count--;
                left++;
            }
            r++;
        }
        return startIndex == -1 ? "" : s.substring(startIndex,startIndex+minLen);
    }
}