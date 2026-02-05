class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            int numIndex = i;
            if(nums[i] > 0){
                int index = nums[i]%n;
                while(index > 0){
                    numIndex = (numIndex+1)%n;
                    index--;
                }
                res[i] = nums[numIndex];
            }else if(nums[i] < 0){
                int index = Math.abs(nums[i]%n);
                numIndex = ((numIndex - index) % n + n) % n;
                res[i] = nums[numIndex];
            }else{
                res[i] = nums[i];
            }
        }
        return res;
    }
}