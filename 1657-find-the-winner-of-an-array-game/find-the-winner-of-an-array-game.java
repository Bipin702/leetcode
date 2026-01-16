class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        
        if(k == 1) return Math.max(arr[0],arr[1]);

        int max = arr[0];
        for(int num : arr){
            if(num > max) max = num;
        }

        if(k >= n-1) return max;

        int currentWinner = arr[0];
        int consecutiveWins = 0;

        for(int i = 1; i < n; i++){
            if(currentWinner > arr[i]){
                consecutiveWins++;
            }else{
                currentWinner = arr[i];
                consecutiveWins = 1;
            }

            if(consecutiveWins == k) return currentWinner;
        }
        return currentWinner;
    }
}