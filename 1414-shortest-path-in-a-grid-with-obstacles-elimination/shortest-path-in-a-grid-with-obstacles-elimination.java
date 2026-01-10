class Solution {
    class Pair{
        int row;
        int col;
        int obs;

        Pair(int row, int col, int obs){
            this.row = row;
            this.col = col;
            this.obs = obs;
        }
    }
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][][] visited = new boolean[41][41][1601];
        Queue<Pair> q = new LinkedList<>();
        visited[0][0][k] = true;
        q.add(new Pair(0,0,k));

        int steps = 0;

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                Pair p = q.poll();

                if(p.row == n-1 && p.col == m-1) return steps;

                for(int i = 0; i < 4; i++){
                    int nRow = p.row + delRow[i];
                    int nCol = p.col + delCol[i];

                    if(nRow < 0 || nRow >= n || nCol < 0 || nCol >= m ) continue;

                    int nextObs = p.obs - grid[nRow][nCol];

                    if(nextObs < 0) continue;

                    if(!visited[nRow][nCol][nextObs]){
                        visited[nRow][nCol][nextObs] = true;
                        q.add(new Pair(nRow,nCol,nextObs));
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}