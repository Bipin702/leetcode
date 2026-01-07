class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        HashMap<Integer,List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map.putIfAbsent(i+j, new ArrayList<>());
                map.get(i+j).add(mat[i][j]);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < map.size(); i++){
            List<Integer> diag = map.get(i);

            if(i % 2 == 0) Collections.reverse(diag);

            ans.addAll(diag);
        }

        return ans.stream().mapToInt(x -> x).toArray();
    }
}