class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[] visited = new boolean[n*n+1];
        visited[1] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                int number = q.poll();

                if(number == n*n) return steps;

                for(int i = 1; i <= 6; i++){
                    int next = number + i;

                    if(next > n*n) break;

                    int[] cords = getCoordinates(next,n);
                    int row = cords[0];
                    int col = cords[1];

                    if(board[row][col] != -1){
                        next = board[row][col];
                    }

                    if(!visited[next]){
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    public int[] getCoordinates(int number, int n){
        int rowFromBottom = (number - 1) / n;
        int r = n - 1 - rowFromBottom;

        int col = (number - 1) % n;
        if (rowFromBottom % 2 == 1) {
            col = n - 1 - col;
        }

        return new int[]{r, col};
    }
}