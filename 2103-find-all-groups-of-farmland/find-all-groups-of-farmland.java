class Solution {
    public int[][] findFarmland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        List<int[]> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 &&
                (i == 0 || grid[i-1][j] == 0) && 
                (j == 0 || grid[i][j-1] == 0)){
                    int r = i;
                    int c = j;

                    //bottom
                    while(r < n && grid[r][j] == 1){
                        r++;
                    }

                    //right
                    while(c < m && grid[i][c] == 1){
                        c++;
                    }

                    result.add(new int[]{i,j,r-1,c-1});
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}