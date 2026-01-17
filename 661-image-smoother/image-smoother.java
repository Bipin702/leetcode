class Solution {
    int[][] direction = {
        {-1,-1},{-1,0},{-1,1},
        {0,-1},{0,0},{0,1},
        {1,-1},{1,0},{1,1}
    };
    public int[][] imageSmoother(int[][] img) {
        int n = img.length;
        int m = img[0].length;

        int[][] result = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int sum = 0;
                int count = 0;

                for(int[] d : direction){
                    int nRow = i+d[0];
                    int nCol = j+d[1];

                    if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m){
                        sum += img[nRow][nCol];
                        count++;
                    }
                }
                result[i][j] = sum/count;
            }
        }
        return result;
    }
}