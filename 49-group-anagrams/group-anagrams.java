class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        int n = strs.length;
        if(strs == null || n == 0) return ans;
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            map.computeIfAbsent(key,k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}