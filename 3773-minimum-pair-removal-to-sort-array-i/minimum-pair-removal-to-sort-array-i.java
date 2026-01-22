class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int count = 0;

        while(!isSorted(nums,n)){
            int minSum = Integer.MAX_VALUE;
            int pos = -1;
            count++;
            for(int i = 1; i < n; i++){
                int sum = nums[i-1] + nums[i];

                if(sum < minSum){
                    minSum = sum;
                    pos = i;
                }
            }
            nums[pos-1] = minSum;

            for(int i = pos; i < n-1; i++) nums[i] = nums[i+1];
            n--;
        }
        return count;
    }

    public boolean isSorted(int[] nums,int n){

        for(int i = 1; i < n; i++){
            if(nums[i] < nums[i-1]) return false;
        }
        return true;
    }
}