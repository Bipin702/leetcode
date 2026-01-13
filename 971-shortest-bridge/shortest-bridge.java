class Solution {
    class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        boolean isFound = false;

        for(int i = 0; i < n && !isFound; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    dfs(i,j,grid,visited,q);
                        isFound = true;
                        break;
                }
            }
        }
        int steps = 0;
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                Pair p = q.poll();

                for(int j = 0; j < 4; j++){
                    int nRow = p.row + delRow[j];
                    int nCol = p.col + delCol[j];

                    if(nRow < 0 || nRow >= n || nCol < 0 || nCol >= m) continue;

                    if(visited[nRow][nCol] == 1) continue;

                    if(grid[nRow][nCol] == 1) return steps;

                    visited[nRow][nCol] = 1;
                    q.add(new Pair(nRow,nCol));
                }
            }
            steps++;
        }
        return steps;
    }

    public void dfs(int row, int col, int[][] grid,int[][] visited, Queue<Pair> q){
        visited[row][col] = 1;
        q.add(new Pair(row,col));
        int n = grid.length;
        int m = grid[0].length;
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(int i = 0; i < 4; i++){
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0 && grid[nRow][nCol] == 1){
                    dfs(nRow, nCol,grid, visited,q);
                }
            }
        }
    }