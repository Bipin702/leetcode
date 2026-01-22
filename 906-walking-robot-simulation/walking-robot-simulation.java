class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();

        for(int[] obst : obstacles){
            set.add(obst[0] + "," + obst[1]);
        }

        int x = 0, y = 0, direction = 0, maxDistance = 0;

        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

        for(int command : commands){
            if(command == -1){
                direction = (direction + 1) % 4;
            }else if(command == -2){
                direction = (direction + 3) % 4;
            }else{
                for(int i = 0; i < command; i++){
                    int newX = x + directions[direction][0];
                    int newY = y + directions[direction][1];

                    if(!set.contains(newX + "," + newY)){
                        x = newX;
                        y = newY;
                        maxDistance = Math.max(maxDistance,x*x+y*y);
                    }else{
                        break;
                    }
                }
            }
        }
        return maxDistance;
    }
}