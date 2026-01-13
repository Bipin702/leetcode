class Solution {
    public int[][] generateMatrix(int n) {
        int[][]  matrix = new int[n][n];
        int dir = 0;

        int top = 0;
        int left = 0;
        int down = n-1;
        int right = n-1;
        int num = 1;

        while(top <= down && left <= right){
            if(dir == 0){
                for(int i = left; i <= right; i++){
                    matrix[top][i] = num++;
                }
                top++;
            }

            if(dir == 1){
                for(int i = top; i <= down; i++){
                    matrix[i][right] = num++;
                }
                right--;
            }

            if(dir == 2){
                for(int i = right; i >= left; i--){
                    matrix[down][i] = num++;;
                }
                down--;
            }

            if(dir == 3){
                for(int i = down; i >= top; i--){
                    matrix[i][left] = num++;
                }
                left++;
            }
            dir++;

            if(dir == 4) dir = 0;
        }
        return matrix;
    }
}