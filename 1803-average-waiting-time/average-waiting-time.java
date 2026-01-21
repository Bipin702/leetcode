class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        long sum = 0;
        int lastFinish = 0;

        for (int[] cust : customers) {
            int arrival = cust[0];
            int cookTime = cust[1];

            int start = Math.max(lastFinish, arrival);
            int finish = start + cookTime;

            sum += finish - arrival;
            lastFinish = finish;
        }

        return (double) sum / n;
    }
}
