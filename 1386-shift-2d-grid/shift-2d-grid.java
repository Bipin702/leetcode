class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < k; i++){
            int[][] temp = new int[n][m];

            for(int j = 0; j < n; j++){
                for(int l = 0; l < m; l++){
                    if(j == n-1 && l == m-1){
                        temp[0][0] = grid[j][l];
                    }else if(l == m-1){
                        temp[j+1][0] = grid[j][l];
                    }else{
                        temp[j][l+1] = grid[j][l];
                    }
                }
            }
            grid = temp;
        }

        List<List<Integer>> answer = new ArrayList<>();

        for(int i = 0; i < n; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < m; j++){
                temp.add(grid[i][j]);
            }
            answer.add(temp);
        }

        return answer;
    }
}