class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int gasSum = 0;
        int costSum = 0;
        for(int i = 0; i < n; i++){
            gasSum += gas[i];
            costSum += cost[i];
        }

        if(gasSum < costSum) return -1;

        int total = 0;
        int result = 0;

        for(int i = 0; i < n; i++){
            total = total - cost[i] + gas[i];
            if(total < 0){
                total = 0;
                result = i+1;
            }
        }
        return result;
    }
}