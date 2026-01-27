class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        for (int i = 0; i <= m - n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + n; j++) {
                sb.append(haystack.charAt(j));
            }
            if (sb.toString().equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
