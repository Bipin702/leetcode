class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;
        int[][] matrix = new int[n][m];
        int i = 0;
        int j = 0;

        while(i < n && j < m){
            matrix[i][j] = Math.min(rowSum[i],colSum[j]);
            rowSum[i] -= matrix[i][j];
            colSum[j] -= matrix[i][j];

            if(rowSum[i] == 0) i++;
            if(colSum[j] == 0) j++;
        }
        return matrix;
    }
}