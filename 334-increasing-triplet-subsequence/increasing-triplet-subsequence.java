class Solution {
    public boolean increasingTriplet(int[] num) {
        int n = num.length;

        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            if(num[i] <= num1){
                num1 = num[i];
            }else if(num[i] <= num2){
                num2 = num[i];
            }else{
                return true;
            }
        }
        return false;
    }
}