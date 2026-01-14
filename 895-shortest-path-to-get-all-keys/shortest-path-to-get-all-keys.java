class Solution {
    class State{
        int row;
        int col;
        int keyStatus;
        int steps;

        State(int row, int col, int keyStatus, int steps){
            this.row = row;
            this.col = col;
            this.keyStatus = keyStatus;
            this.steps = steps;
        }
    }
    public int shortestPathAllKeys(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();

        int keyMask = 0;
        int startR = 0;
        int startC = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                char ch = grid[i].charAt(j);
                if(ch == '@'){
                    startR = i;
                    startC = j;
                }

                if(ch >= 'a' && ch <= 'f'){
                    int bit = ch-'a';
                    keyMask |= (1 << bit);
                }
            }
        }

        Queue<State> q = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][64];
        q.offer(new State(startR,startC,0,0));
        visited[startR][startC][0] = true;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!q.isEmpty()){
            State s = q.poll();
            int rows = s.row;
            int cols = s.col;
            int mask = s.keyStatus;
            int step = s.steps;

            if(mask == keyMask) return step;

            for(int[] d : directions){
                int nRow = rows + d[0];
                int nCol = cols + d[1];

                if(nRow < 0 || nRow >=n || nCol < 0 || nCol >= m) continue;

                char cell = grid[nRow].charAt(nCol);
                
                if(cell == '#') continue;

                int newMask = mask;

                if(cell >= 'a' && cell <= 'f'){
                    int bit = cell - 'a';
                    newMask = mask | (1 << bit);
                }

                //For locks
                if(cell >= 'A' && cell <= 'F'){
                    int bit = cell - 'A';
                    if((mask & (1 << bit)) == 0) continue;
                }
                if(!visited[nRow][nCol][newMask]){
                    visited[nRow][nCol][newMask] = true;
                    q.offer(new State(nRow,nCol,newMask,step+1));
                }
            }

        } 
        return -1;
    }
}