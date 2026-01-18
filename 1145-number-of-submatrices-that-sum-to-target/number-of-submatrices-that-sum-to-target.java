class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0;
        
        //Prefix sum for each row
        for(int i = 0; i < n; i++){
            for(int j = 1; j < m; j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }

        for(int left = 0; left < m; left++){
            for(int right = left; right < m; right++){
                Map<Integer,Integer> map = new HashMap<>();
                map.put(0,1);
                int currSum = 0;
                for(int r = 0; r < n; r++){
                    int rowSum = matrix[r][right];
                    if(left > 0){
                        rowSum -= matrix[r][left-1];
                    }
                currSum += rowSum;

                if(map.containsKey(currSum-target)){
                    count += map.get(currSum-target);
                }

                map.put(currSum,map.getOrDefault(currSum,0)+1);
                }
            }
        }
        return count;
    }
}