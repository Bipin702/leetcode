class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] result = new int[n];

       for(int i = 0; i < n; i++) result[i] = 1;

       for(int i = 1; i < n; i++){
          if(ratings[i] > ratings[i-1]){
            result[i] = result[i-1] + 1;
          }
       }

       for(int i = n-1; i > 0; i--){
            if(ratings[i-1] > ratings[i]){
                result[i-1] = Math.max(result[i] + 1, result[i-1]);
            }
       }
        int sum = 0;

        for(int num : result) sum += num;

        return sum;
    }
}