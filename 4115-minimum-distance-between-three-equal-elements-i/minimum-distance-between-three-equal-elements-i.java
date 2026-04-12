class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(nums[j] == nums[i]){
                    for(int k = j+1; k < n; k++){
                        if(nums[k] == nums[j]){
                            min = Math.min(min,2*(k-i));
                        }
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}