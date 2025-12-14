class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int l = 0;
        int r = n-1;
        int sumLeft = 0;
        int sumRight = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for(int i = 0; i < k; i++){
            sumLeft += cardPoints[i];
        }
        maxSum = sumLeft;
        for(int i = k-1; i >= 0; i--){
            sumLeft -= cardPoints[i];
            sumRight += cardPoints[r];
            r--;
            maxSum = Math.max(maxSum,sumLeft+sumRight);
        }
        return maxSum;
    }
}