class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int time = 0;

        for(int num : left){
            time = Math.max(time,num);
        }

        for(int num : right){
            time = Math.max(time,n-num);
        }

        return time;
    }
}