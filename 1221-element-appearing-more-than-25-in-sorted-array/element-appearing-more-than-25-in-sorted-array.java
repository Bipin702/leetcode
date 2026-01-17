class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int element = 0;
        int freq = n/4;

        for(int i = 0; i < n-freq; i++){
            if(arr[i] == arr[i+freq]){
                element = arr[i];
            }
        }
        return element;
    }
}