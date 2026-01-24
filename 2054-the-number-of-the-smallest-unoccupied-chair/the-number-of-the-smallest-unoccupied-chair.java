class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        int[] chairs = new int[n];
        int targetArrival = times[targetFriend][0];
        Arrays.sort(times,(a,b) -> Integer.compare(a[0],b[0]));
        for(int[] time : times){
            int arrival = time[0];
            int depart = time[1];

            for(int i = 0; i < n; i++){
                if(chairs[i] <= arrival){
                    chairs[i] = depart;

                    if(arrival == targetArrival){
                        return i;
                    }
                break;
                }
            }
        }
        return -1;
    }
}