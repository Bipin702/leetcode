class Solution {
    public boolean checkOnesSegment(String s) {
        char ch = s.charAt(0);
        if(ch == '0') return false;
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                count++;
                while(i < s.length() && s.charAt(i) == '1') i++;
                i--;
            }
        }
        return count == 1;
    }
}