class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int n = points.length;
        int m = points[0].length;

        Arrays.sort(points, (a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int count = 1;
        int lastEnd = points[0][1];

        for(int i = 1; i < n; i++){ // No overlap
            if(points[i][0] > lastEnd){
                count++;
                lastEnd = points[i][1];
            }
        }
        return count;
    }
}