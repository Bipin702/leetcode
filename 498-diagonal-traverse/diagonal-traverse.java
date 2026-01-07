class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.putIfAbsent(i + j, new ArrayList<>());
                map.get(i + j).add(mat[i][j]);
            }
        }

        int[] result = new int[n * m];
        int index = 0;

        for (int d = 0; d <= n + m - 2; d++) {
            List<Integer> diagonal = map.get(d);

            if (d % 2 == 0) {
                Collections.reverse(diagonal);
            }

            for (int val : diagonal) {
                result[index++] = val;
            }
        }

        return result;
    }
}
