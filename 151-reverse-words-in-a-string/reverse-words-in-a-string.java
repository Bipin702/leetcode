class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        int n = arr.length;

        StringBuilder sb = new StringBuilder();

        for(int i = n-1; i >= 0; i--){
            sb.append(arr[i]);
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}