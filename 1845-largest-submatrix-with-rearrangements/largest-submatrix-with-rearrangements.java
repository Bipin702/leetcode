class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 1 && i > 0){
                    matrix[i][j] += matrix[i-1][j];
                }
            }
            int[] heights = matrix[i].clone();
            Arrays.sort(heights);
            for(int k = 0; k < m; k++){
                int base = m-k;
                int height = heights[k];
                maxArea = Math.max(maxArea,base*height);
            }
        }
        return maxArea;
    }
}